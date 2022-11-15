package NestedClasses.InnerClass;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    // Вариант 1: создаем объект иннер класса в конструкторе
    // иннер класс всегда завязан на объекте внешнего класса
//    public Car(String color, int doorCount, int horsePower) {
//        this.color = color;
//        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower);
//    }

    // Вариант 2 и 3: создаем метод setEngine(), которым будем
    // инициализировать объект иннер класса
    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
    }

    public void setEngine(Engine engine){
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    // inner class
    // может содержать только не статические элементы
    // может обращаться к private поляс внешнего класса
    public class Engine {
        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
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
        // Вариант 1: создаем объект иннер класса в конструкторе
//        Car car1 = new Car("black", 4, 300);
//        System.out.println(car1);                // My car{color='black', doorCount=4, engine=My engine{horsePower=300}}

        // Вариант 2: создаем метод setEngine(), которым будем
        // инициализировать объект иннер класса
        Car car2 = new Car("black", 4);
        System.out.println(car2);               // My car{color='black', doorCount=4, engine=null}
        Car.Engine engine2 = car2.new Engine(150);
        car2.setEngine(engine2);
        System.out.println(engine2);             // My engine{horsePower=150}
        System.out.println(car2);               // My car{color='black', doorCount=4, engine=My engine{horsePower=150}}

        // Вариант 3: так будет только ссылка на engine, на car нет
        Car.Engine engine3 = new Car("blue", 4).new Engine(200);
    }
}