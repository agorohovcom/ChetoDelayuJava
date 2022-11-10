package Generics;

import java.util.ArrayList;

public class ParametrizedMethod {
    public static void main(String[] args) {

        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(10);
        al1.add(20);
        al1.add(5);
        int a = GenMethod.getSecondElement(al1);
        System.out.println(a);

        ArrayList<String> al2 = new ArrayList<>();
        al2.add("abc");
        al2.add("def");
        al2.add("ghi");
        String s = GenMethod.getSecondElement(al2);
        System.out.println(s);

    }
}
class GenMethod {
    // так как класс не параметризован, перед типом метода нужно
    // добавить <T>, иначе компилятор не поймет что такое T
//    public static <T> T getSecondElement(ArrayList<T extends Number> a1){     // так не работает
//    public static <T extends Number> T getSecondElement(ArrayList<T> a1){     // так работает
    public static <T> T getSecondElement(ArrayList<T> a1){
        return a1.get(1);
    }
}