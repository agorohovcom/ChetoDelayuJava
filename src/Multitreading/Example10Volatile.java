package Multitreading;

public class Example10Volatile extends Thread{
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished. Counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Example10Volatile thread = new Example10Volatile();
        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds its time to wake up");
        thread.b = false;
        thread.join();
        System.out.println("End of program");
    }
}
