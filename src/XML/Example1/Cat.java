package XML.Example1;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "cat")  // указывает на то, что класс участвует в JAXB сериализации, в ней же задано имя, которое будет у XML-тега для этого класса.
@XmlRootElement         // указывает на то, что этот объект может быть «корнем дерева» элементов в XML
public class Cat {
    public String name;
    public int age;
    public int weight;

    public Cat(){

    }
}
