package XML.Example2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {

        // создание объектов Cat&Zoo для сериализации в XML
        Cat cat1 = new Cat();
        cat1.name = "Rizhiy";
        cat1.age = 2;
        cat1.weight = 5;

        Cat cat2 = new Cat();
        cat2.name = "Chucha";
        cat2.age = 5;
        cat2.weight = 7;

        Zoo zoo = new Zoo();
        zoo.animals.add(cat1);
        zoo.animals.add(cat2);

        // писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        // создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
        Marshaller marshaller = context.createMarshaller();
        // делаем красивый вывод в консоль
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(zoo, writer);

        System.out.println(writer.toString());
    }
}
