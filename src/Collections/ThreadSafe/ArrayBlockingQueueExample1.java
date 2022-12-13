package Collections.ThreadSafe;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue - это потокобезопасная очередь
 * с фиксированным размером (capacity restricted).
 * Обычно один или несколько потоков добавляют элементы
 * в конец очереди, а другой или другие потоки забирают
 * элементы из начала очереди.
 */
public class ArrayBlockingQueueExample1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // пятый элемент не добавится, так как очередь на 4 элемента
        queue.offer(5);

        System.out.println(queue);
    }
}
