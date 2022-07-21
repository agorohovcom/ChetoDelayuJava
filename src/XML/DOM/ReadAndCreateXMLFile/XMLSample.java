package XML.DOM.ReadAndCreateXMLFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class XMLSample {

    public static void main(String[] args) {
        /**
         * 1
         * Запись XML в файл
         * Если массив posts окажется пустым, то новый XML-файл должен будет иметь следующий вид :
         * <?xml version="1.0" encoding="UTF-8"?>
         * <Posts lang="en">
         *     <Users></Users>
         *     <Forums></Forums>
         * </Posts>
         */
//        XMLSample xmlSample1 = new XMLSample();
//        try {
//            xmlSample1.writeDataXML();
//        } catch (TransformerConfigurationException e) {
//            throw new RuntimeException(e);
//        }

        /**
         * Вот так работает
         * Сперва с помощью readDataXML() читает данные из файла posts.xml,
         * затем пишет их в файл data.xml
         */
        XMLSample xmlSample2 = new XMLSample();
        xmlSample2.readDataXML();
        try {
            xmlSample2.writeDataXML();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }

    }

    private final String FILE_post = "src/XML/DOM/ReadAndCreateXMLFile/posts.xml";
    private  final  String  FILE_data = "src/XML/DOM/ReadAndCreateXMLFile/data.xml";
    private List<Post> posts;

    private String getValue(NodeList fields, int index) {
        NodeList list = fields.item(index).getChildNodes();
        if (list.getLength() > 0) {
            return list.item(0).getNodeValue();
        } else {
            return "";
        }
    }

    /**
     * Чтение XML-файла
     * Для чтения XML-файла в проекте используется метод readDataXML(),
     * который создает список (persons типа List<Person> - это ошибка?) posts типа List<Post>,
     * читает XML-файл данных и формирует объект doc типа Document.
     * После этого в цикле создается массив данных.
     * Вспомогательная функция getValue извлекает текст атрибута записи.
     */
    private void readDataXML() {
        posts = new ArrayList<Post>();

        SimpleDateFormat sdf = null;
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;

        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2022-07-21 19:45:01
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = null;

            FileInputStream fis = null;
            if (Files.exists(Path.of(FILE_post))) {
                try {
                    fis = new FileInputStream(FILE_post);
                    doc = db.parse(fis);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            doc.getDocumentElement().normalize();

            NodeList fields = null;
            NodeList nodeList = null;

            nodeList = doc.getElementsByTagName("row");
            for (int s = 0; s < nodeList.getLength(); s++) {
                Node node = nodeList.item(s);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    fields = el.getElementsByTagName("field");
                    Post p = new Post();
                    p.setForum(getValue(fields, 0));
                    p.setDate(sdf.parse(getValue(fields, 1)));
                    p.setSubject(getValue(fields, 2));
                    p.setUsername(getValue(fields, 4));
                    posts.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Создание нового объекта Document
     * и сохранение его в XML-файл в проекте
     */
    private void writeDataXML() throws TransformerConfigurationException {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element e_root = doc.createElement("Posts");
            e_root.setAttribute("lang", "en");
            Element e_users = doc.createElement("Users");
            Element e_forums = doc.createElement("Forums");
            e_root.appendChild(e_users);
            e_root.appendChild(e_forums);
            doc.appendChild(e_root);

            if(posts.size() == 0){
                return;
            }

            List<String> users = new ArrayList<>();
            List<String> forums = new ArrayList<>();

            for(int i = 0; i < posts.size(); i++){
                if(!users.contains(posts.get(i).getUsername())){
                    users.add(posts.get(i).getUsername());
                }
                if (!forums.contains(posts.get(i).getForum())) {
                    forums.add(posts.get(i).getForum());
                }

                System.out.println("    пользователей : " +
                        users.size());

                for(String user : users){
                    Element e = doc.createElement("user");
                    e.setTextContent(user);
                    e_users.appendChild(e);
                }

                System.out.println("    форумов : " + forums.size());
                for (String forum : forums) {
                    Element e = doc.createElement("forum");
                    e.setTextContent(forum);
                    e_forums.appendChild (e);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null){
                writeDocument(doc, FILE_data);
            }
        }
    }

    /**
     * Процедура сохранения объекта Document в XML-файл
     */
    private void writeDocument(Document document, String path)
            throws TransformerConfigurationException {

        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;

        try{
            trf = TransformerFactory.newInstance().newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException | IOException e){
            e.printStackTrace();
        }
    }

}
