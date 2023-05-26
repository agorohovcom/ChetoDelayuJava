package Generics;

import java.util.ArrayList;
import java.util.List;

public class TestWildcard {
    public static void main(String[] args) {
        // так нельзя из-за неоответтвия типов
//        List<Number> list001 = new ArrayList<Integer>();
//        List<Object> list002 = new ArrayList<Integer>();

        // так можно, ? - это любой класс
        List<?> list = new ArrayList<Integer>();
        // при использования wildcard <?> нельзя использовать методы,
        // изменяющие объект
//        list.add("Swing.Hello.Hello");

        // bounded wildcards
        List<? extends Number> list30 = new ArrayList<Integer>();
//        List<? extends Number> list33 = new ArrayList<String>();
        List<? super Number> list35 = new ArrayList<Object>();


        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Привет");
        list2.add("Ок");
        list2.add("Пока");
        showListInfo(list2);

        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.15);
        ald.add(3.16);
        System.out.println(summ(ald));

        ArrayList<Integer> ali = new ArrayList<>();
        ali.add(3);
        ali.add(35);
        ali.add(30);
        System.out.println(summ(ali));

        // так нельзя из-за summ(ArrayList<? extends Number> a1)
//        ArrayList<String> als = new ArrayList<>();
//        System.out.println(summ(als));

    }

    static void showListInfo(List<?> list){
        System.out.println("Мой list содержит следующие элементы:\n" +
                list);
    }

    public static double summ(ArrayList<? extends Number> a1){
        double summ = 0;
        for(Number n : a1){
            summ += n.doubleValue();
        }
        return summ;
    }
}
