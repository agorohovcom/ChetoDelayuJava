package Multitreading;

public class DeadLockException1 {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread10: Попытка захватить монир объекта lock1");
        synchronized (DeadLockException1.lock1) {
            System.out.println("Thread10: Монир объекта lock1 захвачен");
            System.out.println("Thread10: Попытка захватить монир объекта lock2");
            synchronized (DeadLockException1.lock2) {
                System.out.println("Thread10: Монир объектов lock1 и lock2 захвачены");
            }
        }
    }
}

// Чтобы не возникало DeadLock-а,
// нужно чтобы Thread10 и Thread20 делали лок в одинаковом порядке
class Thread20 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread20: Попытка захватить монир объекта lock2");
        synchronized (DeadLockException1.lock2) {
            System.out.println("Thread20: Монир объекта lock2 захвачен");
            System.out.println("Thread20: Попытка захватить монир объекта lock1");
            synchronized (DeadLockException1.lock1) {
                System.out.println("Thread20: Монир объектов lock1 и lock2 захвачены");
            }
        }
    }
}