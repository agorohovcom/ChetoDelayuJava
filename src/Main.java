import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) {
        // Сколько потоков могжет запустить ПК





                var counter = new AtomicInteger();
                while (true) {
                    new Thread(() -> {
                        int count = counter.incrementAndGet();
                        System.out.println("thread count = " + count);
                        LockSupport.park();
                    }).start();
                }
            }

}
