package Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Properties properties = new Properties();
//
//        properties.put("key1", "val1");
//        properties.put("key2", "val2");
//        properties.put("key3", "val3");
//        properties.put("key4", "val4");
//        properties.put("key5", "val5");
//
//        Set keys = properties.keySet();
//
//        for(Object o : keys){
//            System.out.println(o + " ___ " + properties.getProperty(o.toString()));
//        }

        // по видосу https://www.youtube.com/watch?v=LKIT3FgLi7A&t=396s&ab_channel=DmitriyMischuk

        Properties prop = new Properties();


//        //Запись в файл
//        prop.setProperty("Key1", "Java");
//        prop.setProperty("Key2", "Home");
//
//        FileOutputStream fos = null;
//        try{
//            fos = new FileOutputStream("./src/Properties/file.property");
//            prop.store(fos, "My comment");
//        } catch (IOException e){
//            e.printStackTrace();
//        } finally{
//            fos.close();
//        }

        //Чтение из файла
        try(FileInputStream fis = new FileInputStream("./src/Properties/file.property")){
            prop.load(fis);
//            System.out.println(prop.getProperty("Key1"));
//            System.out.println(prop.getProperty("Key2"));
        } catch (IOException e){
            e.printStackTrace();
        }

        //Что-то ещё https://www.youtube.com/watch?v=jPvPbb7u_Nk&ab_channel=DmitriyMischuk
//        Human student = new Student();
//        Human employee = new Employee();

        HumanInterface h = null;
        try {
            h = (HumanInterface) Class.forName(prop.getProperty("Key2")).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        h.printName();
//        employee.printName();

    }
}

class Employee extends Human{
    public Employee() {
        super("Bob");
    }
}

class Student extends Human{
    public Student() {
        super("Anna");
    }
}