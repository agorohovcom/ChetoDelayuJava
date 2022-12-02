package Multitreading;

public class Example8 extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " " + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Example8 thread2 = new Example8();
        thread1.start();
        thread2.start();

        // Поток, В котором вызывается join(), ждёт окончания вызывающего потока
        thread1.join();
        thread2.join();
        System.out.println("Конец main().");
    }
}

class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " " + i);
        }
    }
}