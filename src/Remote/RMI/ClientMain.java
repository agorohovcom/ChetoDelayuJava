package Remote.RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {

    // такое же уникальное имя удаленного объекта, как на сервере
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {

        // получаем доступ к реестру
        final Registry registry = LocateRegistry.getRegistry(2732);

        // получаем из регистра объект, приводим к интерфейсу с нужным методом
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);

        // вызываем удалённый метод
        int multiplyResult = calculator.multiply(20, 30);
        System.out.println(multiplyResult);
    }
}
