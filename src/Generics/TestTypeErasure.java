package Generics;

public class TestTypeErasure {
    public static void main(String[] args) {

    }

    public void abc(Inform<String> inform){
        String s = inform.getValue();
    }

//    public void abc(Inform<Integer> inform){
//        int i = inform.getValue();
//    }
    // после стирания тивов эти методы выглядят так
    // abc(Inform inform) - то есть одинаково
}

class Inform <T> {
    private T value;

    public T getValue(){
        return value;
    }

    public Inform(T value) {
        this.value = value;
    }

    public String toString(){
        return "[<<<{ " + value + " }>>>]";
    }
}

class Parent{
    public void abc(Inform<String> inform){
        String s = inform.getValue();
    }
}

// так переопределить метод abc() не получится из-за механизма стирания типов
//class Child extends Parent{
//    public void abc(Inform<Integer> inform){
//        int i = inform.getValue();
//    }
//}