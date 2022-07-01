package Remote.RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {

    // уникальное имя удаленного объекта
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {

        // создаём экземпляр класса RemoteCalculationServer
        final RemoteCalculationServer server = new RemoteCalculationServer();

        // реестр удаленных объектов, порт выбираем сами
        final Registry registry = LocateRegistry.createRegistry(2732);

        // делаем заглушку, 0 означает выбор любого свободного порта
        Remote stub = UnicastRemoteObject.exportObject(server, 0);

        // регистрируем заглушку
        registry.bind(UNIQUE_BINDING_NAME, stub);

        // спим, чтобы сервер не завершил работу
        Thread.sleep(Integer.MAX_VALUE);
    }
}
