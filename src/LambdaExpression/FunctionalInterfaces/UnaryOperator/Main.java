package LambdaExpression.FunctionalInterfaces.UnaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        /** =================================== ФУНКЦИОНАЛЬНЫЙ ИНТЕРФЕЙС UnaryOperator ===========================
         * =======================================================================================================
         * Наследник Function<T,T>. Описывает операцию над параметром и возврат результата такого же типа. Методы:
         * -------------------------------------------------------------------------------------------------------
         * - T apply (T t) - производит операцию на основе объекта, ссылка на который выступает в качестве
         * параметра, и возвращает результат такого же типа.
         * - default<V> Function<T, V> andThen(Function<? super T, ? extends V> after)) - возвращает композицию
         * реализации UnaryOperator и Function. Сперва выполняется текущая реализация UnaryOperator, а результат будет
         * использован в качестве входящего параметра реализации Function
         * - default<V> Function<V, T> compose(Function<? super V, ? extends T> before) - то же самое в другом порядке
         * - static <T> UnaryOperator<T> identify() - возвращает UnaryOperator, возвращающий значение, переданное
         * в качестве параметра. */

        /** Метод apply()
         * ============= */
        UnaryOperator<String> unOp1 = new UOp();
        System.out.println(unOp1.apply("Swing.Hello.Hello world!"));
        /** Пример реализации с помощью лямбда-функции и ссылки на метод */
        UnaryOperator<Integer> unOp2 = a -> -a;
        // #1
        UnaryOperator<Integer> unOp3 = Main::negative;
        System.out.println(unOp2.apply(43));    // -43
        System.out.println(unOp3.apply(43));    // -43

        /** UnaryOperator<T> в стандартной библиотеке
         * В интерфейсе List<T> определён метод
         * default void replaceAll(UnaryOperator<E> operator)
         * Данный метод заменяет все элементы списка,
         * применяя к каждому элементу списка реализацию UnaryOperator */

        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
        UnaryOperator<Integer> unOp4 = a -> 2*a;
        // Каждый элемент списка удваивается
        list1.replaceAll(unOp4);
        System.out.println(list1);

        /** Метод andThen()
         * ============= */
        UnaryOperator<String> unOp5 = a -> a.strip();
        Function<String, Integer> fun1 = a -> a.length();
        Function<String, Integer> res1 = unOp5.andThen(fun1);
        System.out.println(res1.apply(" hello "));  // 5

        /** Метод compose()
         * ============= */
        Function<String, Integer> fun2 = a -> a.length();
        UnaryOperator<Integer> unOp6 = a -> a*2;
        Function<String, Integer> res2 = unOp6.compose(fun2);
        System.out.println(res2.apply("hello"));    // 10

        /** Метод identity()
         * ============= */
        UnaryOperator<Integer> unOp7 = UnaryOperator.identity();
        System.out.println(unOp7.apply(5));     // 5

        /** ===== Примитивные специализации UnaryOperator ================
         * ===============================================================
         * IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
         * Абстрактный метод: {тип} applyAs{тип}(тип), например int applyAsInt(int operand) */
        // #2
        IntUnaryOperator unOp8 = Main::factorial;
        System.out.println(unOp8.applyAsInt(5));    // 120

        /** Другие методы примитивных специализаций UnaryOperator
         * Методы по умолчанию: andThen, compose
         * Статические: identity
         * Методы по умолчанию возвращают композицию реализаций. Различаются только типом используемого параметра,
         * характерным для своего типа примитивной специализации. Например, для IntUnaryOperator:
         * - default IntUnaryOperator andThen(IntUnaryOperator after)
         * - default IntUnaryOperator compose(IntUnaryOperator before)
         * - static IntUnaryOperator identity()
         */
        IntUnaryOperator unOp9 = a -> a + 1;
        IntUnaryOperator unOp10 = a -> 2*a;
        IntUnaryOperator res3 = unOp9.andThen(unOp10);
        System.out.println(res3.applyAsInt(3));     // 3+1 = 4, 4*2 = 8

    }
    // #1.2
    public static Integer negative(Integer number){
        return -number;
    }

    // #2
    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }



}
// #1.1
class UOp implements UnaryOperator<String>{
    @Override
    public String apply(String s) {
        return s.toLowerCase();
    }
}




// Видео:
// https://www.youtube.com/watch?v=LRSteZdnOOw&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=20
