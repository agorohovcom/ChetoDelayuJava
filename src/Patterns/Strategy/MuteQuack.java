package Patterns.Strategy;

public class MuteQuack implements QuackBehaviour{
    @Override
    public void quack() {
        System.out.println("Я не издаю звуков");
    }
}
