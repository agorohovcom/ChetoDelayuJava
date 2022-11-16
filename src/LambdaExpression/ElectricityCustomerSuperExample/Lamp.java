package LambdaExpression.ElectricityCustomerSuperExample;

public class Lamp implements ElectricityCustomer {
    public void lightOn(){
        System.out.println("Лампа зажглась");
    }

    @Override
    public void electricityOn() {
        lightOn();
    }
}
