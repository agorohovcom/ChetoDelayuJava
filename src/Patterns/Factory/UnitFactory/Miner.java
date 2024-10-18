package Patterns.Factory.UnitFactory;

public class Miner implements Unit {
    @Override
    public void doWork() {
        System.out.println("Минёр закладывает мины");
    }
}
