package XML.Example2;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(name = "zoo")
public class Zoo {
    @XmlElementWrapper(name = "wild-aanimals")
    @XmlElement(name = "tiger")
    public List animals = new ArrayList();
}

class Cat{
    @XmlElement(name = "catname")
    public String name;
    @XmlAttribute(name = "age")
    public int age;
    @XmlAttribute(name = "w")
    public int weight;

    public Cat(){

    }
}
