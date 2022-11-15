package Collections.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

/** Эта очередь выдает не первый добавленный элемент, а элемент согласно сортировке.
 * Нужно чтобы элементы поддерживали Comparable или добавить в параметры Comparator.
 */
public class PriorityQueueExample1 {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(1);
        pq.add(7);
        pq.add(10);
        pq.add(8);
        // вся коллекция не сортируется, но при запросе выдается
        // наименьший элемент согласно сортировке
        System.out.println(pq);             // 1, 4, 7, 10, 8

        System.out.println(pq.peek());      // 1

        System.out.println(pq.remove());    // 1
        System.out.println(pq.remove());    // 4
        System.out.println(pq.remove());    // 7
        System.out.println(pq.remove());    // 8
        System.out.println(pq.remove());    // 10

        System.out.println(pq);
    }
}
