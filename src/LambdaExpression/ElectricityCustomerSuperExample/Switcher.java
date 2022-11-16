package LambdaExpression.ElectricityCustomerSuperExample;

import java.util.ArrayList;

public class Switcher {

    private ArrayList<ElectricityCustomer> customers = new ArrayList<>();
    public void customersSize(){
        System.out.println("Размер списка подписок на событие: " + customers.size() + "\n");
    }

    public void addElectricityCustomer(ElectricityCustomer e) {
        customers.add(e);
    }

    public void removeElectricityCustomer(ElectricityCustomer e){
        customers.remove(e);
    }

    public void switchOn(){
        System.out.println("Выключатель включён");
        if(!customers.isEmpty()){
            for(ElectricityCustomer d : customers){
                d.electricityOn();
            }
        }
    }
}

