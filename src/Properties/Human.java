package Properties;

public class Human implements HumanInterface {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void printName(){
        System.out.printf("My name is %s. I am Instance %s class.", this.name, this.getClass().getName());
    }
}

interface HumanInterface {
    void printName();
}