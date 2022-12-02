package Multitreading;

public class Example9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main() begins");
        Thread thread = new Thread(new Worker());
        // состояние потока: NEW
        System.out.println(thread.getState());
        thread.start();
        // состояние потока: RUNNABLE
        System.out.println(thread.getState());
        thread.join();
        // состояние потока: TERMINATED
        System.out.println(thread.getState());
        // Метод join() может принимать верхний порог ожидания в миллисекундах
//        thread.join(1500);
        System.out.println("Method main() ends");
    }
}

class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work ends");
    }
}