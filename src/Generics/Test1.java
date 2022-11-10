package Generics;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        List list = new ArrayList();
        List<String> list = new ArrayList<>();
//        list.add("OK");
//        list.add(5);
//        list.add(new StringBuilder());
//        list.add(new Car());
        list.add("Привет");
        list.add("Пока");
        list.add("Ок");
        list.add("епкреноеоо");

//        for (Object o : list) System.out.println(o + ", длина " + ((String)o).length());
        for (String o : list) System.out.println(o + ", длина " + o.length());
    }
}

class Car{}