package Collections.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue - коллекция, хранящая последовательность
 * элементов по правилу FIFO.
 */
public class LinkedListExample1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // add() - добавляет элемент в конец очереди
        // Если у очереди есть ограничение, то при добавлении
        // через add() в заполненную очередь будет исключение,
        // а при добавлении через offer() просто ничего не произойдет
        queue.add("Zaur");
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Mariya");
        queue.offer("Aleksandr");

        System.out.println(queue);

        // remove() - удаляет элемент с начала очереди и возвращает его
        System.out.println(queue.remove());
        System.out.println(queue);

        // можно использовать remove() для удаления конкретного элемента,
        // метод вернёт thue при удачном удалении.
        // но тогда нет смысла использовать Queue
        System.out.println("queue.remove(\"Ivan\") " + queue.remove("Ivan"));

        // удаление несуществующего элемента вызовет исключение
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());

        System.out.println(queue);

        // poll() - то же, что remove(), но при применении к
        // путой очереди вернёт null

        // element() - показывает верхний (первый) элемент в очереди
        // при отсутствии элементов выбросит исключение
        System.out.println(queue.element());

        // peek() - то же, что и element(), но при пустой очереди
        // вернет null
    }
}
