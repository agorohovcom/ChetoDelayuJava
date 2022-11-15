package Collections.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * Set - коллекция, хранящая уникальные элементы. Методы очень быстры.
 * HashSet не запоминает порядок добавления элементов, может содержать null.
 * В основе HashSet лежит урезанная версия HashMap с заглушкой вместо значений.
 */
public class HashSetExample1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zaur");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
//        set.add("Igor");
        set.add(null);

        System.out.println(set);

        for(String s : set){
            System.out.println(s);
        }

        set.remove(null);
        System.out.println(set);

        System.out.println(set.size());

        System.out.println(set.isEmpty());

        System.out.println(set.contains("Misha"));

        // get() отсутствует
//        System.out.println(set.get());
    }
}
