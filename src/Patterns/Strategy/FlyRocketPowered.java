package Patterns.Strategy;

public class FlyRocketPowered implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Лечу на реактивной тяге!!!");
    }
}
