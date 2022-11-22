package LambdaExpression.FunctionalInterfaces.Function;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        /** --------- apply() ----------------
         // -----------------------------------
         // Реализация с помощью класса StrToLength
         // *1 */
//        Function<String, Integer> fun = new StrToLength();
//        System.out.println(fun.apply("Hello"));
        /** Реализация с помощью лямбда */
//        Function<String, Integer> fun1 = a -> a.length();
//        System.out.println(fun1.apply("Hello"));
//        Function<String, Integer> fun2 = String::length;
//        System.out.println(fun2.apply("World"));
        /** ---- Пример использования Function ----
         // ---- в качестве параметра метода ------
         // *2 */
//        String text = "Java the best!";
//        Function<String, Integer> fun3 = Main::countWhiteSpase;
//        System.out.println(applyToStr(text, fun3));
        /** Более сложный пример
         // *3 */
//        List<String> list = List.of("Java", "Python", "Fortran", "C");
//        Function<String, Integer> fun4 = a -> a.length();
//        List<Integer> resList = applyAndCreate(fun4, list);
//        System.out.println(resList);
        /** *3.1 вычисляем факториал */
//        List<Integer> numbers = List.of(1,2,3,4,5);
//        Function<Integer, BigInteger> fun5 = n -> {
//          BigInteger factorial = new BigInteger("1");
//          for(int i = 1; i <=n; i++){
//              factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
//          }
//          return factorial;
//        };
//        List<BigInteger> resList2 = applyAndCreate(fun5, numbers);
//        System.out.println(resList2);
        /** --- Function в стандартной библиотеке ----------------------------------------------------
         // ------------------------------------------------------------------------------------------
         // --- default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) ---
         // Этот метод пытается получить значение по ключу. Если ключ есть, метод вернёт его значение.
         // Если нет (или null), то будет получено значение на основе ключа с использованием
         // mappingFunction. Эта пара добавляется в карту, метод возвращает вычисленное значение */
//        Map<Integer, String> numbersMap = new HashMap<>(Map.of(1, "one", 5, "five", 10, "ten"));
//        Integer num = 2;
//        String result = numbersMap.computeIfAbsent(num, n -> "number_" + n);
//        System.out.println(numbersMap);
//        System.out.println(result);
        /** ----- default andThen() ---------------------------
         // ---------------------------------------------------
         // реализует композицию функций
         // *4 */
//        Function<String, String[]> fun6_1 = a -> a.split(" ");
//        Function<String[], int[]> fun6_2 = Main::getLength;
        /** в fun6_3 первым параметром берем то, что является входным параметром первой реализации (fun6_1),
         // а в качестве выходящего значения выбираем тип возвращаемого значения второй реализации (fun6_2)
         // Function <a, c> fun6_3 = Function <a, b> fun6_1 + Function <b, c> fun6_2 */
//        Function<String, int[]> fun6_3 = fun6_1.andThen(fun6_2);
//        int[] result = fun6_3.apply("Java the best!");
//        System.out.println(Arrays.toString(result));
        /** ----- default compose() ---------------------------
         // ---------------------------------------------------
         // тоже реализует композицию функций, но меняет порядок вызова методов */
//        Function<String,String> fun7_1 = a -> a.replaceAll("[^A-Za-z]", "");
//        Function<String,Integer> fun7_2 = a -> a.length();
        /** В fun7_3 сперва вызовется fun7_1 и удалит всё, кроме букв, потом вызовется fun7_2 */
//        Function<String,Integer> fun7_3 = fun7_2.compose(fun7_1);
//        String text = "Hello world 1234, 621, a 15";
//        System.out.println(fun7_3.apply(text));
        /** --- разница между andThen() и compose(): ----
         // в andThen() - первая текущая, второй параметр
         // в compose() - первый параметр, второй текущая
         // ---------------------------------------------
         // ----- static <T> Function <T,T> identity() --
         // --------------------------------------------- */
//        Function<Integer,Integer> fun8 = Function.identity();
//        System.out.println(fun8.apply(100)); // в качестве результата возвращает свой входной параметр
        /** ------ BiFunction -------------------
         // -------------------------------------
         // использует 2 входящих параметра: BiFunction<T,U,R>
         // методы:
         // R apply(T t,U u) - создание объекта R на основании T и U
         // default <V> BiFunction<T,U,V> andThen (Function<? super R, ? extends V> after) -
         // создание композиции из реализаций BiFunction. Первой выз текущая реализ, второй - используемая в кач параметра
         // * 5 apply() */
//        BiFunction<String,Character,Integer> countLetter = Main::biCount;
//        System.out.println(countLetter.apply("Hello", 'l'));
        /** andThen() */
//        BiFunction<String, String, String[]> fun8_1 = (a,b) -> a.split(b);
//        Function<String[], String> fun8_2 = a -> String.join("", a);
//        BiFunction<String, String, String> fun8_3 = fun8_1.andThen(fun8_2);
//        String text2 = "Java the    best";
//        String reg = "{1,}\s";
//        String result2 = fun8_3.apply(text2, reg);
//        System.out.println(result2);
        /** ------- Примитивные специализации Funcyion -------
         * Есть 3 вида: принимающие, производящие и принимающе-производящие.
         * Принимающие: IntFunction(), LongFunction, DoubleFunction
         */
//        LongFunction<Date> fun9_1 = a -> new Date(a);
//        System.out.println(fun9_1.apply(4_00_000_000_000L));
        /** Производящие: ToIntFunction<T>, ToLongFunction<T>, ToDoubleFunction<T>
         * метод apply() называется applyAsInt(), applyAsLong() и applyAsDouble
         */
//        ToIntFunction<String> fun10 = a -> a.hashCode();
//        System.out.println(fun10.applyAsInt("Hello"));
        /** Принимающие и производящие специализации Function:
         * IntToLongFunction        applyAsLong()
         * IntToDoubleFunction      applyAsLong()
         * LongToDoubleFunction     applyAsDouble()
         * LongToIntFunction        applyAsDouble()
         * DoubleToIntFunction      applyAsInt()
         * DoubleToLongFunction     applyAsInt()
         */ // *6
//        DoubleToIntFunction fun11 = Main::convert;
//        System.out.println(fun11.applyAsInt(1.99));
        /** ---------- Примитивные специализации BiFunction ---------
         * -----------------------------------------------------------
         * ToIntBiFunction<T,U>     applyAsInt()
         * ToLongBiFunction<T,U>    applyAsLong()
         * ToDoubleBiFunction<T,U>  applyAsDouble()
         */
//        ToIntBiFunction<Character, Character> fun12 = (a,b) -> a + b;
//        System.out.println(fun12.applyAsInt('a', 'b'));
    }

    // *2
    public static Integer applyToStr(String text, Function<String, Integer> fun3){
        return fun3.apply(text);
    }
    public static Integer countWhiteSpase(String text){
        int n = 0;
        char[] s = text.toCharArray();
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                n = n + 1;
            }
        }
        return n;
    }

    // *3
    public static <R, T> List<R> applyAndCreate(Function<T, R> fun4, List<T> list){
        List<R> resultList = new ArrayList<>();
        for(T t : list){
            resultList.add(fun4.apply(t));
        }
        return resultList;
    }

    // *4
    public static int[] getLength(String[] arr){
        int[] result = new int[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = arr[i].length();
        }
        return result;
    }

    // *5
    public static Integer biCount(String letter, Character l){
        int result = 0;
        char[] ls = letter.toCharArray();
        for(int i = 0; i < ls.length; i++){
            if(ls[i] == l){
                result++;
            }
        }
        return result;
    }

    // *6
    public static int convert(double num){
        return (int) num;
    }

}

// *1
class StrToLength implements Function<String, Integer>{
    @Override
    public Integer apply(String t) {
        return t.length();
    }
}

// Ссылка:
// https://www.youtube.com/watch?v=wUp2TLL4F6E&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=15&ab_channel=OleksandrTsymbaliuk
