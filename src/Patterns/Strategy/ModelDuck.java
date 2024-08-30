package Patterns.Strategy;

public class ModelDuck extends Duck{

    public ModelDuck(){
        setFlyBehaviour(new FlyNoWay());
        setQuackBehaviour(new Quack());
    }

    @Override
    public void display() {
        System.out.println("Я модель утки");
    }
}
