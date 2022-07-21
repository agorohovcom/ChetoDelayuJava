package XML.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CreateXMLDocument {
    public static void main(String[] args) throws ParserConfigurationException {

        /**
         * Создание XML-файла
         */
        DocumentBuilderFactory dbf;
        DocumentBuilder db ;
        Document doc;

        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();
        doc = db.newDocument();

        /**
         * Элемент Element объекта Document создается с использованием
         * метода createElement. Для определения значения элемента следует
         * использовать метод setTextContent.
         * Для добавления элемента в узловую запись используйте метод
         * appendChild (Node). Элемент может содержать атрибуты.
         * Чтобы добавить к элементу атрибут следует использовать метод
         * setAttribute. Если элемент уже содержит атрибут,
         * то его значение изменится.
         */
        Element root = doc.createElement("Users");

        Element user = doc.createElement("user");
        user.setTextContent("Саша Горохов");
        user.setAttribute("blog", "Блог Александра Горохова");
        root.appendChild(user);
        doc.appendChild(root);

    }
}
