package Collections.Set;

import java.util.LinkedHashSet;

/**
 * Являетя наледником HashSet. Хранит информацию о порядке добавления
 * элементов. В основе LinkedHashSet лежит HashMap,
 * запонимать последний используемый элемент нет.
 * Производительность ниже, чем у методов HashSet.
 * Ключи - элементы, значения - заглушки.
 * Нужен как HashSet с возможностью запоминать последовательность добавления.
 */
public class LinkedHashSetExample1 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(10);
        System.out.println(lhs);

        lhs.remove(8);
        System.out.println(lhs);

        System.out.println(lhs.contains(8));
        System.out.println(lhs.contains(10));
    }
}
