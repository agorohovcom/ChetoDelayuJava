public class DoSomething {
    public static void main(String[] args) {
        Bicycle bicycle = (Bicycle) new BicycleFactory().getCycle();
    }
}

interface Cycle{
    void ride();
}

interface CycleFactory{
    Cycle getCycle();
}

class Bicycle implements Cycle{
    Bicycle(){}
    @Override
    public void ride() {
        System.out.println("Bicycle is riding");
    }
}

class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        System.out.println("Получи велосипеды");
        return new Bicycle();
    }
}