package Multitreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {
    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();
        Long valueDivided10 = value/10;
        for(int i = 0; i < 10; i++){
            long from = valueDivided10*i+1;
            long to = valueDivided10*(i+1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum = executorService.submit(task);
            futureResults.add(futurePartSum);
        }
        for(Future<Long> result : futureResults){
            sum += result.get();
        }
        executorService.shutdown();
        System.out.println("Total sum = " + sum);
    }
}

class PartialSum implements Callable<Long>{
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for(long i = from; i <= to; i++){
            localSum += i;
        }
        System.out.println("Sum from " + from +
                " to " + to + " = " +
                localSum);
        return localSum;
    }
}

// Output:

//    Sum from 500000001 to 600000000 = 55000000050000000
//    Sum from 600000001 to 700000000 = 65000000050000000
//    Sum from 400000001 to 500000000 = 45000000050000000
//    Sum from 700000001 to 800000000 = 75000000050000000
//    Sum from 300000001 to 400000000 = 35000000050000000
//    Sum from 200000001 to 300000000 = 25000000050000000
//    Sum from 1 to 100000000 = 5000000050000000
//    Sum from 100000001 to 200000000 = 15000000050000000
//    Sum from 800000001 to 900000000 = 85000000050000000
//    Sum from 900000001 to 1000000000 = 95000000050000000
//    Total sum = 500000000500000000
//
//    Process finished with exit code 0

