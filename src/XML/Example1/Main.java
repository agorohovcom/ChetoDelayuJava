package XML.Example1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {

        // СЕРИАЛИЗАИЯ В XML

        Cat cat1 = new Cat();
        cat1.name = "Puhsok";
        cat1.age = 13;
        cat1.weight = 54;


        StringWriter writer = new StringWriter();

        // создаём объект Marshaller, который выполняет сериализацию
        JAXBContext context1 = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context1.createMarshaller();
        // делаем красивый вывод в консоль
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // сама сериализация
        marshaller.marshal(cat1, writer);

        System.out.println(writer.toString());

        // ДЕСЕРИАЛИЗАЦИЯ ИЗ XML

        String xmldata = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context2 = JAXBContext.newInstance(Cat.class);
        Unmarshaller unmarshaller = context2.createUnmarshaller();

        Cat cat2 = (Cat) unmarshaller.unmarshal(reader);

    }
}
