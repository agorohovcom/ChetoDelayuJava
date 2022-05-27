package Serialize.Example2;

import java.io.Externalizable;
import java.io.Serializable;

public class Cat implements Serializable {

//    private static final long serialVersionUID = 1l;
    private String name;
    private static String a = "1";
    private transient String b = "2";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
