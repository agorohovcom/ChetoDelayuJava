package Multitreading;

import java.util.concurrent.*;

public class RunnableFactorial {
    static int factorialResult;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial1 factorial = new Factorial1(6);
//        executorService.execute(factorial);
        Future future = executorService.submit(factorial);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(future.get());       // null
        future.isDone();
        System.out.println(factorialResult);
    }
}

class Factorial1 implements Runnable{
    int f;

    public Factorial1(int f) {
        this.f = f;
    }

    @Override
    public void run() {
        if(f<=0){
            System.out.println("Вы ввели неверное число");
            return;
        }
        int result = 1;
        for(int i = 1; i <= f; i++){
            result *= i;
        }
        RunnableFactorial.factorialResult = result;
    }
}
