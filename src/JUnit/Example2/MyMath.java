package JUnit.Example2;

public class MyMath {
    public static int add(int a, int b) throws InterruptedException {
        Thread.sleep(300);
        return a+b;
    }
    public static int div(int a, int b){
        return a/b;
    }
}
