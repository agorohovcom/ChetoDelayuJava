package Generics;

import java.util.ArrayList;
import java.util.List;

public class TestSubtyping {
    public static void main(String[] args) {
        X x = new Y();      // UpCasting
        // Так не работает, потому что
        // совокупность ArrayList<Y>
        // не является подтипом List<X>
//        List<X> list1 = new ArrayList<Y>();
        // а так можно
//        List<X> list1 = new ArrayList<X>();

        // так тоже нельзя
//        List<Number> list = new ArrayList<Integer>();
//        list.add(18);
//        list.add(3.14);


    }
}

class X{}

class Y extends X{}