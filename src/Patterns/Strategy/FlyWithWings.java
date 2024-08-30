package Patterns.Strategy;

public class FlyWithWings implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Я лечу!!!");
    }
}
