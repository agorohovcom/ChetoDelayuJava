package Serialize.Example1;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    // если не хотим сериализовывать поле - ключевое слово transient

//    private static final long serialVersionUID = -3452887687645346346L;
    // нужен для того, чтобы помечать состояние класса. если класс поменялся, то
    // это поле не даст восстановить некорректный объект старого класса в новом

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}
