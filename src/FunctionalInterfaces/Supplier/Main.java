package FunctionalInterfaces.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /** =================== Функциональный интерфейс SUPPLIER =====================
         * ============================================================================
         * Метод:
         * T get() - создаёт объект типа T и возвращает ссылку на него */

        /** Реализация Supplier с помощью класса */
        // #1
        Supplier<Integer> counter = new IntegerSequince(0, 10, 1);
        Integer number;
        for (; (number = counter.get()) != null; ) {
            System.out.println(number);
        }

        /** Реализация Supplier с помощью лямбда-функции и ссылки на метод */
        Supplier<Integer> supLambda = () -> (int) (Math.random() * 10);
        // #2
        Supplier<Integer> supMethLink = Main::getRandomNumber;

        System.out.println(supLambda.get());
        System.out.println(supMethLink.get());

        /** Использование Supplier в качестве ссылки на конструктор - "ленивое" создание объекта */
        Supplier<List<String>> sup3 = ArrayList::new;
        List<String> list1 = sup3.get();
        System.out.println(list1);      // получим пустой список

        /** ==================== Применение Supplier в стандартной библиотеке ======================
         * =========================================================================================
         * В классе Optional описан метод:
         * public T orElseGet(Supplier<? extends T> supplier)
         * Если значение присутствует в Optional, возвращает значение, в противном случае возвращает
         * результат, полученный с помощью реализации Supplier */
        // #3
        String[] names = new String[]{"Luke", "Darth", "Obi-Wan", "R2D2"};
        String firstLetter = "J";
        // Описанный ниже подход и называется ленивым созданием объекта, так как если firstLetter
        // удачно найдена, то строка "Name not found. May the force be with you." не будет создана.
        Optional<String> name = Optional.ofNullable(findNameByFirstLetter(names, firstLetter));
        String result = name.orElseGet(() -> "Name not found. May the force be with you.");
        System.out.println(result);

        /** ========== Примитивные специализации Supplier ===========================================
         * BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier - {тип} getAs{Тип}() */
        // #4
        IntSupplier intSup = new RandomGenerator(10, 20);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = intSup.getAsInt();       // использование метода Supplier
        }
        System.out.println(Arrays.toString(array));
        // массив будет заполнен случайными числами от 10 до 20

    }
    // #3
    public static String findNameByFirstLetter(String[] names, String firstLetter){
        for(String name : names)
            if(name.startsWith(firstLetter))
                return name;
        return null;
    }

    // #2
    public static Integer getRandomNumber(){
        return (int) (Math.random() * 10);
    }
}
// #1
class IntegerSequince implements Supplier<Integer> {
    private Integer start;
    private Integer end;
    private Integer step;

    public IntegerSequince(Integer start, Integer end, Integer step){
        this.start = start;
        this.end = end;
        this.step = step;
    }
    @Override
    public Integer get() {
        if(start > end)
            return null;
        start += step;
        return (start - step);
        }
}

// #4
class RandomGenerator implements IntSupplier{
    private int min;
    private int max;

    public RandomGenerator(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public int getAsInt() {
        return (int) (min + Math.random() * (max - min));
    }
}

// Видео:
// https://www.youtube.com/watch?v=cl12wAVFPrU&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=22&ab_channel=OleksandrTsymbaliuk