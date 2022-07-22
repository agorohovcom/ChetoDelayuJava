package XML.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        /**
         * Получить объект Document XML-файла можно следующим образом
         */
        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document doc;

        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.parse(new File("src/XML/DOM/data1.xml"));

        /**
         * Создание XML-файла
         */
//        doc = db.newDocument();

        /**
         * Чтобы найти какой-либо узел в дереве можно использовать метод
         * getElementsByTagName(), который возвращает список всех элементов
         */
        NodeList nodeList = doc.getElementsByTagName("office");

        /**
         * Узнать имена узлов - getNodeName()
         * Метод getNodeType() позволяет проверить тип узла
         */
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println("Имя узла: " + node.getNodeName());
            System.out.println("Тип узла: " + node.getNodeType());
        }
        System.out.println("___");

        /**
         * C помощью метода getAttributes можно узнать атрибуты узла.
         */
        Node currentNode = nodeList.item(0);
        NamedNodeMap namedNodeMap = currentNode.getAttributes();
        System.out.println("Атрибуты первого узла:");
        for(int i = 0; i < namedNodeMap.getLength(); i++){
            System.out.println(namedNodeMap.item(i));
        }
        System.out.println("___");

        /**
         * getChildNodes() - просмотреть все дочерние узлы.
         */
        NodeList children = currentNode.getChildNodes();
        System.out.println("Дочерние узлы:");
        for(int i = 0; i < children.getLength(); i++){
            // дочерний узел
            Node node = children.item(i);
            System.out.println(node.getNodeName());
        }
        System.out.println("___");


    }
}
