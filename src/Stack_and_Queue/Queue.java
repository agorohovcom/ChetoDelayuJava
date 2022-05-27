package Stack_and_Queue;

public interface Queue<T>{
    void add(T item);       // добавить элемент в конец очереди
    T remove();             // удалить элемент из начала очереди

    boolean isEmpty();
}
