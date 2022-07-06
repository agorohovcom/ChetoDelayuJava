package Patterns.ServiceLocator;

// Конкретная услуга 1
public class Service1 implements Service{

    @Override
    public void execute(){
        System.out.println("Executing Service1");
    }

    @Override
    public String getName() {
        return "Service1";
    }
}
