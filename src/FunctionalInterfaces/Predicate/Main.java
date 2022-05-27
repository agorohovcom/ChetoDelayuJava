package FunctionalInterfaces.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 4);
        Cat cat5 = new Cat("Kuzia", 2);
        List<Cat> cats = new ArrayList<>(List.of(cat1,cat2,cat3,cat4,cat5));
        // --------- test() --------------
//        cats.removeIf(a -> a.getAge() <6 );
        // или так
//        cats.removeIf(Main::testCat);
        // --- default and() -------------
//        Predicate<Cat> pr1 = a -> a.getAge() < 5;
//        Predicate<Cat> pr2 = a -> a.getName().startsWith("K");
//        cats.removeIf(pr1.and(pr2));
        // --- default or() -------------
//        Predicate<Cat> pr1 = a -> a.getAge() < 5;
//        Predicate<Cat> pr2 = a -> a.getAge() > 10;
//        cats.removeIf(pr1.and(pr2));
        // --- default negate() ---------
        // реализует оператор not текущего предиката
//        List<Integer> numbers = new ArrayList<>(List.of(-1, 4, 5, 0, -2));
//        Predicate<Integer> pr1 = n -> n > 0;
//        numbers.removeIf(pr1.negate());
//        System.out.println(numbers);

        // ------- static not() ---------
        // генерирует предикат на основании того, что в параметре
//        cats.removeIf(Predicate.not(a->a.getAge() < 6));

        // ------- static isEqual() -----
//        List<String> names = new ArrayList<>(List.of("Anna", "Ira", "Katia", "Anna"));
//        Predicate<String> pr1 = Predicate.isEqual("Anna");
//        names.removeIf(pr1);
//        System.out.println(names);
//        // этот класс делает то же самое, что и isEqual()
//        class NamePredicate<T> implements Predicate<T>{
//            private T baseElement;
//            public NamePredicate(T baseElement){
//                super();
//                this.baseElement = baseElement;
//            }
//            @Override
//            public boolean test(T t) {
//                return Objects.equals(t, baseElement);
//            }
//        }
//        Predicate<String> pr2 = new NamePredicate<>("Anna");
//        names.removeIf(pr2);

        System.out.println(cats);

        // ------- BiPredicate -----
        // Это бинарная специализация предиката
        // Методы: test(), and(), or(), negate()
//        BiPredicate<String, Integer> biPred = (a, b) -> a.length() > b;
        // -- Примитивные специализации Predicate -----
        // IntPredicate, LongPredicate, DoublePredicate
//        IntPredicate pr = a -> a%2 == 0;
//        System.out.println(pr.test(100));
        // или так через метод countElement
//        int[] array = new int[]{-4, 1, 6, -3, 0, 1, 7};
//        int even = countElement(array, a -> a%2 == 0);
//        int odd = countElement(array, a -> a%2 != 0);
    }

    public static boolean testCat(Cat cat){
        return cat.getAge() < 6;
    }
    public static int countElement(int[] array, IntPredicate pr){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(pr.test(array[i])){
                count++;
            }
        }
        return count;
    }
}

// Ссылка на видео:
// https://www.youtube.com/watch?v=rfVhHnxBdc0&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=16&ab_channel=OleksandrTsymbaliuk