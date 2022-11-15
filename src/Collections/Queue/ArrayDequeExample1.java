package Collections.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque - double ended queue (двунаправленная очередь).
 * Элементы могут использоваться с обоих концов - FIFO и LIFO.
 * Интерфейс Deque реализуется классами LinkedList и ArrayDeque.
 */
public class ArrayDequeExample1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        // addFirst(), addLast() - добавить в начало/конец, может
        // выбросить Exception при заполненной очереди
        // offerFirst(), offerLast() - то же, но не выбрасывает Exception
        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        deque.offerFirst(1);
        deque.offerLast(8);

        System.out.println(deque);                  // [1, 5, 3, 7, 8]

        // removeFirst(), removeLast() - удалить с начала/конца, может
        // выбросить Exception при отсутствии элементов
        // pollFirst(), pollLast() - то же, но не выбрасывает Exception
        System.out.println(deque.removeFirst());    // 1
        System.out.println(deque);                  // [5, 3, 7, 8]
        System.out.println(deque.removeLast());     // 8
        System.out.println(deque);                  // [5, 3, 7]
        System.out.println(deque.pollFirst());      // 5
        System.out.println(deque);                  // [3, 7]
        System.out.println(deque.pollLast());       // 7
        System.out.println(deque);                  // [3]

        // getFirst(), getLast() - возвращает первый/поледний элемент, если
        // очередь пуста - выбрасывает Exception
        // peekFirst(), peekLast() - то же самое, но выдаёт null если нет элементов

        System.out.println(deque.peekFirst());      // 3
        deque.remove();
        System.out.println(deque.peekFirst());      // null
    }
}
