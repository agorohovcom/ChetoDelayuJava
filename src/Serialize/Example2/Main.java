package Serialize.Example2;

import java.io.InvalidObjectException;

public class Main {
    public static void main(String[] args) {

        // Запись
//        Cat cat = new Cat();
//        cat.setName("Tom");
//        Serializator serializator = new Serializator();
//        System.out.println(serializator.serialization(cat));

        // Чтение
        Serializator serializator = new Serializator();
        try {
            Cat cat = serializator.deserialization();
            System.out.println(cat.getName());
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

    }
}
