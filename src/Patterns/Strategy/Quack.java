package Patterns.Strategy;

public class Quack implements QuackBehaviour{
    @Override
    public void quack() {
        System.out.println("Кря-кря!");
    }
}
