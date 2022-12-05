package Multitreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample1 {
    public static void main(String[] args) {
        Call call = new Call();
        // создаю 3 потока разными способами:
        // анонимный класс, лямбда-выражение и ссылка на метод
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(() -> call.skypeCall());
        Thread thread3 = new Thread(call::whatsAppCall);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        System.out.println("Mobile call starts");
        try {
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // unlock() всегда нужно писать в finally
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        System.out.println("Skype call starts");
        try {
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void whatsAppCall() {
        lock.lock();
        System.out.println("WhatsApp call starts");
        try {
            Thread.sleep(7000);
            System.out.println("WhatsApp call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}