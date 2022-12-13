package Multitreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

//        for(int i = 0; i < 10; i++){
//            scheduledExecutorService.execute(new RunnableImplementation200());
//        }

        // метод schedule() выполнит наши таски через определенный промежуток времени
//        scheduledExecutorService.schedule(new RunnableImplementation200(),
//                3, TimeUnit.SECONDS);

        // scheduleAtFixedRate() планирует задачу для периодического выполнения
        // с начала выполнения первой задачи до начала выполнения второй задачи
//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImplementation200(),
//                3, 1, TimeUnit.SECONDS);

        // scheduleWithFixedDelay() фиксирует промежуток времени между
        // завершением одной задачи и началом следующей
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImplementation200(),
                3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
        scheduledExecutorService.shutdown();

        // Кешированный Thread pool создаёт потоки по мере необходимости.
        // Если 60 секунд поток не получает заданий, поток удаляется.
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}

class RunnableImplementation200 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}