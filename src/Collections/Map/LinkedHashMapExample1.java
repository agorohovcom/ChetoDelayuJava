package Collections.Map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap является наследником HashMap.
 * Хранит информациб о порядке добавления элементов или
 * порядке их использования.
 * Производительность ниже, чем у HashMap.
 * В конструкторе 3 параметра:
 * 1. initialCapacity (16) - размер внутреннего массива
 * 2. loadFactor (0.75f) - коэффициент заполненности для расширения
 * 3. boolean accessOrder() - если true, то последним в LinkedHashMap
 * становится элемент, который последним использовался
 */
public class LinkedHashMapExample1 {
    public static void main(String[] args) {
        LinkedHashMap<Double, Student> lhm =
                new LinkedHashMap<>(16, 0.75f, true);
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);
        lhm.put(7.2, st3);
        lhm.put(7.5, st4);
        lhm.put(5.8, st1);
        lhm.put(6.4, st2);
        System.out.println(lhm);

        System.out.println(lhm.get(5.8));
        System.out.println(lhm.get(7.5));
        System.out.println(lhm);

    }
}
