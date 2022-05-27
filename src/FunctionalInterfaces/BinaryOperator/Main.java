package FunctionalInterfaces.BinaryOperator;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) {
        /** =========== ФУНКЦИОНАЛЬНЫЙ ИНТЕРФЕЙС BinaryOperator ===============================================
         * ====================================================================================================
         * Наследник BiFunction<T,T,T>. Описывает операцию над объектами одного типа и
         * возвращает результат того же типа.
         * Методы:
         * - T apply (T t1, T t2) - производит операцию на основе объектов, ссылки на которые выступают
         * в качестве параметров, и возвращает результат в виде ссылки того же типа.
         * - default <V>BiFunction <T,T,V> andThen(Function<? super T, ? extends V> after) - возвращает
         * композицию BinaryOperator и Function. Сначала будет применяться текущий оператор, и к результату
         * будет применена функция, выступающая в качестве параметра.
         * - static<T>BinaryOperator<T> minBy(Comparator<? super T> comparator) - возвращает BinaryOperator,
         * который возвращает меньший из двух параметров в соответствии с указанным Comparator.
         * - static<T>BinaryOperator<T> maxBy(Comparator<? super T> comparator) - то ж самое, но
         * возвращает больший. */

        /** =================== Примеры использования BinaryOperator ===========================================
         * ================================================================================================== */

        /** Реализация с помощью класса */
        // #1
        BinaryOperator<String> biOpByClass = new StringConcat(5);
        String text1 = biOpByClass.apply("Hello", "cat");
        System.out.println(text1);      //Hello

        /** Реализация BinaryOperator с помощью ссылки на метод и лямбда-функции */
        BinaryOperator<Integer> binOpByLambda = (a, b) -> a + b;
        // #2
        BinaryOperator<Integer> binOpByMethLink = Main::sum;

        System.out.println(binOpByLambda.apply(1,3));       // 4
        System.out.println(binOpByMethLink.apply(1,3));     // 4

        /** Более сложный пример применения BinaryOperator - реализуем свёртку списка.
         * Свёртка списка - функция высшего порядка, которая принимает структуру данных
         * и сводит её к единственному атомарному значению. Должно быть 3 компонента:
         * public static <T> T reduce(List<T> list, BinaryOperator<T> binOpSvList, T startValue){ }
         * 1. List <T> - список
         * 2. BinaryOperator<T> - комбинирующая функция
         * 3. startValue - начальное значение.
         * Реализация на Java с помощью BinaryOperator: */
        // #3
        List<Integer> list1 = List.of(1,2,3);
        BinaryOperator<Integer> binOp1 = (a, b) -> a + b;
        Integer s1 = reduce(list1, binOp1, 0);
        System.out.println(s1);     // 6

        List<String> list2 = List.of("Hello", "Java", "world");
        BinaryOperator<String> binOp2 = (a, b) -> a + " " + b;
        String s2 = reduce(list2, binOp2, "");
        System.out.println(s2);     //  Hello Java world

        /** Метод andThen() функционального интерфейса BinaryOperator */
        BinaryOperator<String> binOp3 = (a, b) -> a + b;
        Function<String, Integer> func1 = a -> a.length();
        BiFunction<String, String, Integer> biFunc1 = binOp3.andThen(func1);
        Integer result1 = biFunc1.apply("Hello", "World");
        System.out.println(result1);        // 10

        /** Методы maxBy() и minBy() функционального интерфейса BinaryOperator */
        Comparator<String> cmp1 = (a, b) -> Integer.compare(a.length(), b.length());
        BinaryOperator<String> binOp4 = BinaryOperator.maxBy(cmp1);
        String result2 = binOp4.apply("Java", "Python");
        System.out.println(result2);        // Python

        /** ==== Примитивные специализации BinaryOperator ==============================================
         * =============================================================================================
         * IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator - {тип} applyAs{Тип}(тип, тип) */
        // #4
        IntBinaryOperator intBinOp = Main::gcd;
        System.out.println(intBinOp.applyAsInt(20, 15));        // 5

    }
    // #4
    public static int gcd(int a, int b){
        // метод находит наибольший общий делитель
        a = Math.abs(a);
        b = Math.abs(b);
        if(b > a){
            int temp = a;
            a = b;
            b = temp;
        }
        int r = a%b;
        for(; r != 0;){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }


    // #3
    public static <T> T reduce(List<T> list, BinaryOperator<T> binOpSvList, T startValue){
        T result = startValue;
        for(T element : list){
            result = binOpSvList.apply(result, element);
        }
        return result;
    }

    // #2
    public static Integer sum(Integer a, Integer b){
        return a + b;
    }
}

// #1
class StringConcat implements BinaryOperator<String>{
    private int minLength;

    public StringConcat(int minLength){
        super();
        this.minLength = minLength;
    }
    @Override
    public String apply(String t1, String t2) {
        String a = t1.length() >= minLength ? t1 : "";
        String b = t2.length() >= minLength ? t2 : "";
        return a+b;
    }
}


// Видео:
// https://www.youtube.com/watch?v=kZeP2IpWPh4&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=21