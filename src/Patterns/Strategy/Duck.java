package Patterns.Strategy;

public abstract class Duck {

    private FlyBehaviour flyBehaviour;
    private QuackBehaviour quackBehaviour;

    public Duck(){}

    public abstract void display();

    public void swim(){
        System.out.println("Все утки плавают, даже манки!");
    }

    public void performFly(){
        flyBehaviour.fly();
    }

    public void performQuack(){
        quackBehaviour.quack();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour;
    }
}
