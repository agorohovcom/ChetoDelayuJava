package Remote.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// интерфейс с методом, который мы будем удаленно вызывать
// extends Remote и throws RemoteException - обязательно!!!
public interface Calculator extends Remote {
    int multiply(int x, int y) throws RemoteException;
}
