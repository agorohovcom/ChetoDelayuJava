package Collections.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionExample2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            arrayList.add(i);
        }

        // создаём синхронизированную обёртку для arrayList
        List<Integer> syncList =
                Collections.synchronizedList(arrayList);

        Runnable runnable1 = () -> {
            // без использования synchronized блока может выбросить ошибку
            // из-за одновременной итерации первым потоком и удаления вторым потоком
            // поэтому работу итератора нужно заключать в synchronized блок
            synchronized (syncList) {
                Iterator<Integer> iterator = syncList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };
        Runnable runnable2 = () ->
                syncList.remove(10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(syncList);
    }
}
