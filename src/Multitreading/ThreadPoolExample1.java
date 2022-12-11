package Multitreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample1 {
    public static void main(String[] args) throws InterruptedException {
        // создаём Thread pool на 5 потоков
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // создаём Thread pool на 1 поток
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 1; i < 10; i++){
            executorService.execute(new RunnableImplementation100());
        }
        // заканчиваем работу ExecutorService
        executorService.shutdown();
        //
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Main ends");
    }
}

class RunnableImplementation100 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}