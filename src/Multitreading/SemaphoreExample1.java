package Multitreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Zaur", callBox);
        new Person("Oleg", callBox);
        new Person("Elena", callBox);
        new Person("Viktor", callBox);
        new Person("Marina", callBox);
    }
}

class Person extends Thread{
    String name;
    private Semaphore callBox;
    public Person(String name, Semaphore callBox){
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " ждёт...");
        try {
            // попытка получить разрешение от семафора
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
            Thread.sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // освобождаем семафор
            callBox.release();
        }
    }
}

// Output:

//        Marina ждёт...
//        Marina пользуется телефоном
//        Oleg ждёт...
//        Oleg пользуется телефоном
//        Elena ждёт...
//        Zaur ждёт...
//        Viktor ждёт...
//        Marina завершил(а) звонок
//        Oleg завершил(а) звонок
//        Elena пользуется телефоном
//        Viktor пользуется телефоном
//        Viktor завершил(а) звонок
//        Elena завершил(а) звонок
//        Zaur пользуется телефоном
//        Zaur завершил(а) звонок
//
//        Process finished with exit code 0