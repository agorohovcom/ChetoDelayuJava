package Collections.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap не подходит для многопоточности, для этого есть ConcurrentHashMap
 * Элементы HashMap - пары ключ/значение.
 * HashMap не запоминает порядок добавления элементов,
 * его методы работают очень быстро.
 * Ключи должны быть уникальными, может быть null.
 * Если добавить элемент с существующим ключем, он перезапишет значение.
 */
public class HashMapExample1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();

        // put() - добавить элемент
        map1.put(1000, "Zaur Tregulov");
        map1.put(3568, "Ivan Ivanov");
        map1.put(6578, "Mariya Sidorovna");
        map1.put(1000, "Nikolay Petrov");
        map1.put(null, "Sergey Petrov");
        map1.put(2212, null);
        System.out.println(map1);

        // putIfAbsent() - добавить, если такого ключа нет
        map1.putIfAbsent(1000, "Oleg Ivanov");
        System.out.println(map1);

        // get() - возвращает элемент по ключу. если такого нет, выдаст null
        System.out.println(map1.get(1000));

        // remove()
        map1.remove(6578);
        System.out.println(map1);

        // containsValue() - true если в HashMap есть такое значение
        System.out.println(map1.containsValue("Ivan Ivanov"));

        // containsKey() - true если есть такой ключ
        System.out.println(map1.containsKey(500));
        System.out.println(map1.containsKey(3568));

        // keySet() - возвращает сет ключей из HashMap
        System.out.println(map1.keySet());

        // values() - возвращает сет значений из HashMap
        System.out.println(map1.values());
    }
}
