package StreamAPI;

import java.util.Arrays;

public class ForEachTest1 {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};

        // forEach
//        Arrays.stream(array).forEach(el -> {
//            el*=2;
//            System.out.println(el);
//        });

        // одно и то же
        Arrays.stream(array).forEach( el -> System.out.println(el) );
        Arrays.stream(array).forEach(System.out::println);

        // одно и то же
        Arrays.stream(array).forEach( el -> Utils.myMeth(el));
        Arrays.stream(array).forEach(Utils::myMeth);
    }
}

class Utils{
    public static void myMeth(int a){
        a=a+5;
        System.out.println("Element = " + a);
    }
}