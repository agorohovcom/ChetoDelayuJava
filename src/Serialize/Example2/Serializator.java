package Serialize.Example2;

import java.io.*;

public class Serializator {

    public boolean serialization(Cat cat){
        boolean flag = false;

        File file = new File("src/Serialize/Example2/cat.data");
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if(fos!=null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(cat);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    public Cat deserialization() throws InvalidObjectException {
        File file = new File("src/Serialize/Example2/cat.data");
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis!=null){
                ois = new ObjectInputStream(fis);
                Cat cat = (Cat) ois.readObject();
                return cat;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException("Object fail");
    }

}
