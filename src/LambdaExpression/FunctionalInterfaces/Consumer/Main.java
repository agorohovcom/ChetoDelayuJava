package LambdaExpression.FunctionalInterfaces.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        /** ========== Функциональный интерфейс Consumer =============================
         * ===========================================================================
         * Используется для описания операции над объектом без возврата результата.
         *
         * ===== Методы Consumer =====================================================
         * ===========================================================================
         * void accept(T t)
         * выполняет операцию над объектом, ссылка на который передаётся в качестве параметра
         * ----------------------------------------------------------------------------
         * default Consumer<T> andThen(Consumer<? super T> after)
         * возвращает композицию Consumer. Первым выполнится текущий Consumer, вторым -
         * переданный в параметры Consumer*/

        /** Использование метода accept()
         * ============================ */
        Consumer<String> cons1 = new HashCodePrinter<>();
        cons1.accept("Hello");
        /** Реализация accept() ссылкой на метод и лямбда-функцией */
        Consumer<String> cons2 = a -> System.out.println("{" + a + "}");
        Consumer<String> cons3 = Main::simplePrinter;
        cons2.accept("Hello world!");
        cons3.accept("Hello world!");

        /** Побочный эффект метода accept():
         * -Читать и модифицировать значения глобальных переменных или полей класса
         * -Осуществлять операции ввода/вывода
         * -Реагировать на исключительные ситуации, вызывать их обработчики
         * Если вызвать метод с побочным эффектом дважды, вы можете получить
         * разные результаты выполнения */

        List<String> result = new ArrayList<>();
        String s = "J";

        Consumer<String> cons4 = a -> {
            if(a.startsWith(s))
                result.add(a);
        };

        cons4.accept("Java");
        cons4.accept("Julia");
        cons4.accept("Python");

        System.out.println(result);

        /** ======== Использование Consumer в стандартной библиотеке ========
         * В интерфейсе Iterable объявлен метод:
         * default void forEach(Consumer<? super T> action)
         * Этот метод выполняет действие, заданное с помощью реализации Consumer,
         * для каждого элемента, участвующего в итерации.
         * ЧЕЛОВЕЧЕСКИМ ЯЗЫКОМ: Можно упростить вывод в консоль коллекций, например. Круто! */

        List<String> list = new ArrayList<>(List.of("Java", "Fortran", "Python"));
        Consumer<String> cons5 = a -> System.out.println(a);
        list.forEach(cons5);

        /** Использование метода andThen()
         * ============================ */

        Consumer<String> cons6 = a -> System.out.print("*" + a);
        Consumer<String> cons7 = a -> System.out.println("*");
        // result2 - это композиция cons6 и cons7
        Consumer<String> result2 = cons6.andThen(cons7);
        result2.accept("Hello");                        // *Hello*

        /** ======== Бинарная специализация - BiConsumer<T, U> ================================
         * ====================================================================================
         * Принимает 2 параметра и не возвращает результата. Методы:
         * - void accept(T t, U u)
         * - default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after)  */

        BiConsumer<String, Integer> biCons1 = (a, b) -> System.out.println(a.repeat(b));
        // repeat повторит a b раз
        biCons1.accept("Hello", 3);

        /** BiConsumer в стандартной библиотеке
         * default void forEach(BiConsumer<? super K, ? super V> action) */

        Map<Integer, String> map1 = Map.of(1, "one", 2, "two", 5, "five");
        BiConsumer<Integer, String> biCons2 = (a, b) -> System.out.println((b + " ").repeat(a));
        map1.forEach(biCons2);

        /** ========== Примитивные специализации Consumer =================
         * ================================================================
         * IntConsumer, LongConsumer, DoubleConsumer */

        IntConsumer intCons = a -> {
            if(a%2 == 0)
                System.out.println(a + " even number");
            else
                System.out.println(a + " odd number");
        };
        intCons.accept(5);

    }

    public static <T> void simplePrinter(T operand){
        System.out.println("{" + operand + "}");
    }
}

class HashCodePrinter<T> implements Consumer<T>{
    @Override
    public void accept(T t) {
        System.out.println(t.hashCode());
    }
}


// Видео:
// https://www.youtube.com/watch?v=IVUVcdzcrcw&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=22