package LambdaExpression.ElectricityCustomerSuperExample;

public class Main {

    public static void vibratorOn(){
        System.out.println("Вибратор бррррр");
    }

    public static void main(String[] args) {

        Switcher switcher = new Switcher();
        Lamp lamp1 = new Lamp();
        Radio radio1 = new Radio();

        switcher.addElectricityCustomer(lamp1);
        switcher.addElectricityCustomer(radio1);



        switcher.addElectricityCustomer(
                () -> System.out.println("Где-то затрещал вибратор") );

        switcher.addElectricityCustomer(Main::vibratorOn);








        switcher.customersSize();
        switcher.switchOn();

    }
}

