package Collections.Map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Элементы TreeMap - пары ключ/значение,
 * хранятся в отсортированном по возрастанию порядке.
 * Ключи должны быть уникальными, иначе при добавлении
 * произойдёт перезапись.
 * Ключ должен быть Comparable или реализовывать компаратор.
 * Значения могут быть не уникальными.
 * В основе TreeMap лежит красно-чёрное дерево. Из-за этого
 * TreeMap работает быстро, но не быстрее HashMap.
 * Не является synchronized.
 */
public class TreeMapExample1 {
    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<Double, Student>();
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);
        Student st5 = new Student("Vasiliy", "Smirnov", 1);
        Student st6 = new Student("Sasha", "Kapustin", 3);
        Student st7 = new Student("Elena", "Sidorova", 4);
        Student st8 = new Student("Elena", "Sidorova", 4);
        treeMap.put(7.5, st4);
        treeMap.put(7.9, st5);
        treeMap.put(9.1, st7);
        treeMap.put(6.4, st2);
        treeMap.put(5.8, st1);
        treeMap.put(7.2, st3);
        treeMap.put(8.2, st6);
        treeMap.put(3.2, st8);
        System.out.println(treeMap);
//        System.out.println(treeMap.get(6.4));
//        treeMap.remove(5.8);
//        System.out.println(treeMap);

        // descendingMap() - разворачивает в обратную сторону
        System.out.println(treeMap.descendingMap());

        // tailMAp() - выводит ключи от параметра и выше
        System.out.println(treeMap.tailMap(7.3));

        // tailMAp() - выводит ключи от параметра и ниже
        System.out.println(treeMap.headMap(7.3));

        // lastEntry() - последний элемент (с самым большим ключем)
        System.out.println(treeMap.lastEntry());

        // firstEntry - первый элемент (с самым маленьким ключем)
        System.out.println(treeMap.firstEntry());



        // Ключ должен быть Comparable или реализовывать компаратор
//        TreeMap<Student, Double> treeMap2 = new TreeMap<Student, Double>();
        TreeMap<Student, Double> treeMap2 = new TreeMap<Student, Double>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        treeMap2.put(st4, 7.5);
        treeMap2.put(st5, 7.9);
        treeMap2.put(st7, 9.1);
        treeMap2.put(st2, 6.4);
        treeMap2.put(st1, 5.8);
        treeMap2.put(st3, 7.2);
        treeMap2.put(st6, 8.2);
        treeMap2.put(st8, 3.2);
        System.out.println(treeMap2);
    }
}
