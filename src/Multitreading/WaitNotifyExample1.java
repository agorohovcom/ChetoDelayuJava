package Multitreading;

public class WaitNotifyExample1 {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}

class Market {
    private int breadCount = 0;
//    private final Object lock = new Object();

//    public void getBread(){
//        synchronized (lock) {
//            while (breadCount < 1) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            breadCount--;
//            System.out.println("Потребитель купил 1 хлеб");
//            System.out.println("Колличество хлеба в магазине = " + breadCount);
//            lock.notify();
//        }
//    }

    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Колличество хлеба в магазине = " + breadCount);
        notify();

    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Колличество хлеба в магазине = " + breadCount);
        notify();
    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}

// Пример вывода в консоль:

//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 1
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 2
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 3
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 4
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 5
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 4
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 3
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 2
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 1
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 0
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 1
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 2
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 3
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 4
//        Производитель добавил на витрину 1 хлеб
//        Колличество хлеба в магазине = 5
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 4
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 3
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 2
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 1
//        Потребитель купил 1 хлеб
//        Колличество хлеба в магазине = 0
//
//        Process finished with exit code 0
