package Stack_and_Queue;

public interface Stack<T> {
    void push(T item);          // добавить элемент на вершину стека
    T pop();                    // взять элемент с вершины стека

    boolean isEmpty();
}
