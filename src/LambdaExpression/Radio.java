package LambdaExpression;

public class Radio implements ElectricityCustomer {
    public void radioOn(){
        System.out.println("Радио заиграло");
    }

    @Override
    public void electricityOn() {
        radioOn();
    }
}
