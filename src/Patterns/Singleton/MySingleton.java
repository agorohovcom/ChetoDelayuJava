package Patterns.Singleton;

public class MySingleton {
    private static volatile MySingleton instance;

    private MySingleton() {
        System.out.println("Инициализация объекта MySingleton");
    }

    public static MySingleton getInstance() {
            if (instance == null) {
                synchronized (MySingleton.class) {
                    if (instance == null) {
                        instance = new MySingleton();
                        System.out.println("instance = new MySingleton();");
                    }
                }
            }
        return instance;
    }
}

class MySingletonTest {
    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();
        MySingleton mySingleton3 = MySingleton.getInstance();
    }
}