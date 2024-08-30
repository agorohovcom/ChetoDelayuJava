package Patterns.Strategy;

public class FlyNoWay implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Я не умею летать");
    }
}
