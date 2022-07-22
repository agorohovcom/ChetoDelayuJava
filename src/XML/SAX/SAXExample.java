package XML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Чтобы протестировать разные примеры, нужно раскомментировать код с соотсетствующими пометками.
 *
 * => Пример 1: достать всю информацию про всех сотрудников из файла data1.xml.
 *
 * => Пример 2: достать всю информацию про всех сотрудников из файла data2.xml.
 *
 * => Пример 3: дан элемент element, вывести имена и атрибуты всех внутренних элементов,
 * если элемент не найден — вывести "Элемент не был найден.", файл data3.xml.
 */

public class SAXExample {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        /**
         * Создание фабрики и образца парсера
         */
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // ===== пример 1 =====
        // ====================
//        XMLHandler handler = new XMLHandler();  // это экземпляр нашего вложенного класса-обработчика
//        parser.parse(new File("src/XML/SAX/data1.xml"), handler);
//
//        for(Employee employee : employees){
//            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", employee.getName(), employee.getJob()));
//        }

        // ===== пример 2 =====
        // ====================
//        XMLHandler handler = new XMLHandler();
//        parser.parse(new File("src/XML/SAX/data2.xml"), handler);
//
//        for (Employee employee : employees) {
//            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", employee.getName(), employee.getJob()));
//        }

        // ====== пример 3 ======
        // ======================
        XMLHandler handler = new XMLHandler("root");
        parser.parse(new File("src/XML/SAX/data3.xml"), handler);
        if(!handler.isFound){
            System.out.println("Элемент не был найден.");
        }
    }


    // === список сотрудников для примера 1 и 2  ===
    // =============================================
//    private static ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Создаём обработчик событий для нашего парсера
     * и переопределяем его методы (какие нужны)
     */
    private static class XMLHandler extends DefaultHandler {

        // ===== пример 2 =====
        // ====================
//        private String name, job, lastElementName;

        // ===== пример 3 =====
        // ====================
        private String element;
        // isEntered() означает, внутри ли мы нужно нам элемента, и если внутри – считывать все данные из startElement()
        private boolean isEntered;
        private boolean isFound;
        // конструктор для примера 3
        public XMLHandler(String element){
            this.element = element;
        }

        @Override
        public void startDocument() throws SAXException {
            /**
             * Тут будет логика реакции на начало документа
             */
        }

        @Override
        public void endDocument() throws SAXException {
            /**
             * Тут будет логика реакции на конец документа
             */
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            /**
             * Тут будет логика реакции на начало элемента.
             * uri — это пространство, в котором находится элемент,
             * localName — это имя элемента без префикса,
             * qName — это имя элемента с префиксом (если он есть, иначе просто имя элемента).
             * uri и localName всегда пустые, если мы не подключили в фабрике обработку пространств.
             * Это делается методом фабрики setNamespaceAware(true).
             * Тогда мы сможем получать пространство (uri) и элементы с префиксами перед ними (localName).
             */
            // ====== пример 1  ======
            // =======================
//            if(qName.equals("employee")){
//                String name = attributes.getValue("name");
//                String job = attributes.getValue("job");
//                employees.add(new Employee(name, job));
//            }

            // ===== пример 2 =====
            // ====================
//            lastElementName = qName;

            // ====== пример 3 ======
            // ======================
            if(isEntered){
                System.out.println(String.format("Найден элемент <%s>, его атрибуты:", qName));
                int length = attributes.getLength();
                for(int i = 0; i < length; i++){
                    System.out.println(String.format("    Имя атрибута: %s, его значение: %s", attributes.getQName(i), attributes.getValue(i)));
                }
            }
            if(qName.equals(element)){
                isEntered = true;
                isFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            /**
             * Тут будет логика реакции на конец элемента.
             * uri — это пространство, в котором находится элемент,
             * localName — это имя элемента без префикса,
             * qName — это имя элемента с префиксом (если он есть, иначе просто имя элемента).
             * uri и localName всегда пустые, если мы не подключили в фабрике обработку пространств.
             * Это делается методом фабрики setNamespaceAware(true).
             * Тогда мы сможем получать пространство (uri) и элементы с префиксами перед ними (localName).
             */
            // ====== пример 2 ======
            // ======================
//            if((name != null && !name.isEmpty()) && (job != null && !job.isEmpty())){
//                employees.add(new Employee(name, job));
//                name = null;
//                job = null;
//            }

            // ====== пример 3 ======
            // ======================
            if(qName.equals(element)){
                isEntered = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            /**
             * Тут будет логика реакции на текст между элементами.
             * Усли в элементе будет текст, например, «hello», то, теоретически,
             * метод способен вызваться 5 раз подряд на каждый отдельный символ,
             * однако это не страшно, так как все равно все будет работать.
             */
            // ====== пример 2 ======
            // ======================
//            String information = new String(ch, start, length);
//            information = information.replace("\n", "").trim();
//            if(!information.isEmpty()){
//                if(lastElementName.equals("name")){
//                    name = information;
//                }
//                if(lastElementName.equals("job")){
//                    job = information;
//                }
//            }
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            /**
             * Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
             */
        }
    }
}
