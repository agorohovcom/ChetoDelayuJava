package Multitreading;

public class Example4QuickStart {
    public static void main(String[] args) {
        // вариант 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет");
            }
        }).start();

        // вариант 2
        new Thread(() -> System.out.println("привет")).start();
    }
}
