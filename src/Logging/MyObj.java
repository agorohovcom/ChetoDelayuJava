package Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyObj {

    private static final Logger logger = LoggerFactory.getLogger(MyObj.class);

    private int id;
    private String name;

    public MyObj(int id, String name){
        logger.info("Info: MyObj Constructor, id = " + id + "name = " + name);
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
