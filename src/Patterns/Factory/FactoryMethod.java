package Patterns.Factory;

public class FactoryMethod {
    public static void main(String[] args) {
        Cat cat = Cat.createCat("Tom");
        System.out.println(cat);
    }
}

class Cat {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private Cat(){}

    public static Cat createCat(String name){
        Cat c = new Cat();
        c.setName(name);
        return c;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}