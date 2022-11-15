package NestedClasses.StaticNestedClass;

public class Car {
    String color;
    int doorCount;
    Engine engine;
    private static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    void method(){
        System.out.println(Engine.countOfObjets);
        System.out.println(new Engine(345).horsePower);
    }

    @Override
    public String toString() {
        return "My car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    // static nested class
    public /*final*/ /*abstract*/ static class Engine /*extends Z*/{
        private int horsePower;
        static int countOfObjets;

        public Engine(int horsePower) {
            // внутренний класс может обращаться статичным полям внешнего, даже приватным
            System.out.println(a);
//            System.out.println(doorCount);        // нельзя, это нестатичный метод
            this.horsePower = horsePower;
            countOfObjets++;
        }

        @Override
        public String toString() {
            return "My engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test{
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);                 // My engine{horsePower=256}
        Car car = new Car("red", 2, engine);
        System.out.println(car);                    // My car{color='red', doorCount=2, engine=My engine{horsePower=256}}


    }
}

// от внутреннего класса можно наследоваться
class Z extends Car.Engine {
    public Z(int horsePower) {
        super(200);
    }
}