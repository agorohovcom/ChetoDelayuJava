package Serialize.Example1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
//        Person person1 = new Person(1, "Bob");
//        Person person2 = new Person(2, "Mike");
        Person[] people = {new Person(1, "Bob"), new Person(2, "Mike"), new Person(3, "Tom")};

        try {
            FileOutputStream fos = new FileOutputStream("src/Serialize/Example1/people.bin");   //записывает последовательность байтов
            ObjectOutputStream oos = new ObjectOutputStream(fos);                             //записывает объекты

//            oos.writeObject(person1);
//            oos.writeObject(person2);

            // 1 способ сохранить массив
//            oos.writeInt(people.length);
//
//            for(Person person : people){
//                oos.writeObject(person);
//            }

            // 2 способ сохранить массив - массив тоже объект
            oos.writeObject(people);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
