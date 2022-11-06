package Upcasting;

public class Car extends Transport{
    @Override
    void ride() {
        System.out.println("Метод ride() класса Car");
    }
}
