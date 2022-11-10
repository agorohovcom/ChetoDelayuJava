package Generics;

public class ParametrizedClass {
    public static void main(String[] args) {
        // клмпилятор не даёт создать, так как String не extends Number
//        Info<String> info1 = new Info<>("привет");
//        System.out.println(info1);
//        String s = info1.getValue();
        Info<Integer> info2 = new Info<>(101);
        System.out.println(info2);
        int i = info2.getValue();

        Info<Double> info3 = new Info<>(25.4);
        System.out.println(info3);
    }
}

class Info <T extends Number /*& I1 & I2 - так добавл. интерфейсы */> { // все классы от Number и ниже
//    private static T value;   // параметризованная переменная не может быть статичной
    private T value;

    public T getValue(){
        return value;
    }

    public Info(T value) {
        this.value = value;
    }

    public String toString(){
        return "[<<<{ " + value + " }>>>]";
    }
}

interface I1{}
interface I2{}