package Polymorphism.Upcasting;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.ride();
        // Метод ride() класса Car

        Transport transport = new Transport();
        transport.ride();
        // Метод ride() класса Transport

        Transport bike = new Car();
        bike.ride();
        // Метод ride() класса Car

//        Car moto = (Car) new Transport();
//        moto.ride();
        // ClassCastException
    }
}
