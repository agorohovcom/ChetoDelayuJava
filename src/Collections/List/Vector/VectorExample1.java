package Collections.List.Vector;

import java.util.Vector;

/**
 * Vector - устаревший synchronized класс.
 * В основе содержит массив Object.
 * Методы: add(), get(), remove(), firstElement(), lastElement()
 */
public class VectorExample1 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Zaur");
        vector.add("Misha");
        vector.add("Oleg");
        vector.add("Katya");
        System.out.println(vector);

        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        vector.remove(2);
        System.out.println(vector);
        System.out.println(1);
    }
}
