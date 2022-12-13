package Multitreading;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample1 {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        // уменьшаем счётчик на 1
        countDownLatch.countDown();
        // чему равен счётчик сейчас
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        // уменьшаем счётчик на 1
        countDownLatch.countDown();
        // чему равен счётчик сейчас
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        // уменьшаем счётчик на 1
        countDownLatch.countDown();
        // чему равен счётчик сейчас
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }
    public static void main(String[] args) throws InterruptedException {
        new Friend("Zaur", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Viktor", countDownLatch);
        new Friend("Marina", countDownLatch);

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }
}

class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            // await() ждет, пока счетчик CountDownLatch больше 0
            countDownLatch.await();
            System.out.println(name + " приступил(а) к закупкам");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}