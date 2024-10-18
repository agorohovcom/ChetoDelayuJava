package Patterns.Factory.UnitFactory;

public class Soldier implements Unit {
    @Override
    public void doWork() {
        System.out.println("Солдат марширует");
    }
}
