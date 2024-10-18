package Patterns.Factory.UnitFactory;

public class Pilot implements Unit {
    @Override
    public void doWork() {
        System.out.println("Пилот управляет самолётом");
    }
}
