package Patterns.Command;

public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void dig() {
        System.out.println("Работник " + name + " роет яму...");
    }

    public void sweep() {
        System.out.println("Работник " + name + " метёт...");
    }

    public void smoke() {
        System.out.println("Работник " + name + " курит...");
    }
}
