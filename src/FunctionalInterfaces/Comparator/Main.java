package FunctionalInterfaces.Comparator;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {
        /** ===== Функциональный интерфейс Comparator =====
         * ================================================
         * Метод: int compare(T o1, T o2)
         * Если o1 > o2 возвращает положительное число
         * Если o1 < o2 возвращает отрицательное число
         * Если o1 == o2 возвращает 0 */
        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 5);
        Cat cat5 = new Cat("Kuzia", 2);
        Cat[] cats = new Cat[] {cat1, cat2, cat3, cat4, cat5};

        CatAgeComparator comp = new CatAgeComparator();
        /** Рекомендованная проверка своей реализации Comparator
         * =================================================== */
        /** 1 - Проверка на ассиметричность - должно быть true */
//        System.out.println(comp.compare(cat1, cat2) == -comp.compare(cat2, cat1));
        /** 2 - проверка на транзитивность - должно быть true */
//        System.out.println(comp.compare(cat1, cat2) > 0 &&
//                comp.compare(cat2, cat5) > 0 && comp.compare(cat1, cat5) >0);
        /** 3 - Проверка на правило равенства знаков - должно быть true */
//        System.out.println(comp.compare(cat2, cat4) == 0 &&
//                (comp.compare(cat2, cat1) < 0 && comp.compare(cat4, cat1) < 0));
        /** ================================================== */

        /** Где в стандартной библиотеке используется Comparator
         * ===================================================
         * Метод static <T> void sort (T[] a, Comparator<? super T> c) */

//        Arrays.sort(cats, comp);
//        for (Cat cat : cats) System.out.println(cat);

        /** Использование через лямбда-выражение и ссылку на метод
         * ===================================================== */
//        Comparator<Cat> compLambda = (a, b) -> a.getAge() - b.getAge();
//        Comparator<Cat> compLinkToMeth = Main::catAgeCompare;

        /** Ещё одна реализация интерфейса Comparator
         * ========================================= */

//        Integer[] array = new Integer[] {5, 0, -3, -1, 4};
//        Comparator<Integer> compIntAbs = (a, b) -> Math.abs(a) - Math.abs(b);
//        Arrays.sort(array, compIntAbs);
//        System.out.println(Arrays.toString(array));

        /** ==================== МЕТОДЫ COMPARATOR ПО УМОЛЧАНИЮ ======================
         * default Comparator reversed()
         * --- возвращает обратный компаратор на основе текущего компаратора
         * ===========================================================================
         * default Comparator<T> thenComparing(Comparator<? superT> other)
         * --- вернёт компаратор, созданный на основе текущего и выступающего в качестве параметра
         *
         * default <U extends Comparable<? superU>> Comparator<T>
         *     thenComparing(Function<? superT, ? extends U> keyExtractor)
         * --- вернёт компаратор, созданный на основе текущего компаратора для ключа,
         * созданного с помощью функции, используемой в качестве параметра
         *
         * default <U> Comparator<T> thenComparing(Function<? super T, extends U>
         *     keyExtractor, Comparator<? superU> keyComparator)
         * --- вернёт компаратор, созданный на основе текущего и ключа сравнения, созданного
         * на основе функции и компаратора, для него выступающего в качестве параметров
         * ============================================================================
         * default Comparator<T> thenComparingDouble (ToDoubleFunction <? super T> keyExtractor)
         * --- вернёт компаратор, созданный на основе текущего и
         * функции для получения ключа сортировки типа double
         *
         * default Comparator<T> thenComparingInt (ToDoubleFunction <? super T> keyExtractor)
         * --- вернёт компаратор, созданный на основе текущего
         * и функции для получения ключа сортировки типа int
         *
         * default Comparator<T> thenComparingLong (ToDoubleFunction <? super T> keyExtractor)
         * --- вернёт компаратор, созданный на основе текущего и
         * функции для получения ключа сортировки типа long
         * =========================================================================
         * ======= ПРИМЕРЫ ИСПОЛЬЗОВАНИЯ DEFAULT МЕТОДОВ COMPARATOR ================
         *
         * default Comparator reversed() */

//        Comparator<Cat> compReverse = comp.reversed(); // разворачивает другой компаратор

        /** thenComparing(Comparator<? superT> other
         * цепочки сравнений: если первый компаратор возвращает 0, за работу принимается второй */
//        Comparator<Cat> comp1 = (a, b) -> Integer.compare(a.getAge(), b.getAge());
//        Comparator<Cat> comp2 = (a, b) -> a.getName().compareTo(b.getName());
//        Comparator<Cat> comp3 = comp1.thenComparing(comp2);
//        // если comp1 выдал 0, сравнивается с помощью comp2
//        Arrays.sort(cats, comp3);
//        for(Cat cat : cats)
//            System.out.println(cat);

        /** thenComparing(Function<? superT, ? extends U> keyExtractor)
         * составной компаратор, где первый - текущий, а второй построен
         * на основании сравнения объектов, которые вернёт реализация Function, методом compareTo */
//        Comparator<Cat> comp4 = (a,b) -> Integer.compare(a.getAge(), b.getAge());
//        Function<Cat, String> fun = a -> a.getName();
//        // получаем строки из имён котов
//        Comparator<Cat> compRes1 = comp4.thenComparing(fun);
//        // если comp4 вернёт 0, вызовется compareTo для строк - это и есть
//        // второй компаратор в нашем thenComparing
//        Arrays.sort(cats, compRes1);
//        for(Cat cat : cats)
//            System.out.println(cat);

        /** thenComparing(Function<? super T, extends U> keyExtractor, Comparator<? superU> keyComparator)
         * На вход принимает 2 параметра: первый - реализация Function совместимого типа с
         * текущей реализацией Comparator по типу входящего параметра
         * второй - реализация Comparator совместимого типа с результатом работы Function
         * #2 */
//        Comparator<Cat> comp3 = (a, b) -> Integer.compare(a.getAge(), b.getAge());
//        Comparator<Cat> comp3Res = comp3.thenComparing(Main::catToString, Main::compareStringLength);
//        // Получили составной компаратор, который первым параметром принимает Function, возвращающий строку из Cat,
//        // а второй - Comparator, который работает с полученными строками.
//        Arrays.sort(cats, comp3Res);
//        for(Cat cat : cats)
//            System.out.println(cat);
        /** thenComparingInt, thenComparingDouble, thenComparingLong
         * в качестве параметра получают примитивную специализацию интерфейса Function
         * */
//        Comparator<Cat> comp4 = (a, b) -> a.getName().compareTo(b.getName());
//        ToIntFunction<Cat> fun2 = a -> a.getAge();
//        Comparator<Cat> comp4Res = comp4.thenComparingInt(fun2);
//        Arrays.sort(cats, comp4Res);
//        for(Cat cat : cats)
//            System.out.println(cat);


        /** =========================== СТАТИЧЕСКИЕ МЕТОДЫ COMPARATOR ==========================
         * =====================================================================================
         * 1. static<T> Comparator <T> nullsFirst(Comparator<? super T> comparator)
         * создаёт "дружественный" к наличию null Comparator. null значение всегда меньше
         *
         * 2. static <T> Comparator nullLast(Comparator<? super T> comparator)
         * то ж самое, но значение null всегда больше
         * -------------------------------------------------------------------------------------
         * 3. static <T extends Comparable<? superT>> Comparator<T> naturalOrder()
         * вернёт Comparator на основе реализации Comparable<T> для объектов указанного типа
         *
         * 4. static <T extends Comparable<? super T>> Comparator<T> reverseOrder()
         * то же самое, только вернёт "обратный" компаратор
         * -------------------------------------------------------------------------------------
         * 5. static <T,U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ?extends U> keyExtractor)
         * вернёт Comparator на основании сравнения (метод compareTo) результатов работы Function (параметр)
         *
         * 6. static <T,U extends Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator)
         * вернёт Comparator на основании сравнения (метод compareTo) результатов работы Function (параметр) с Comparator для них
         * -------------------------------------------------------------------------------------
         * 7. static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)
         * 8. static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor)
         * 9. static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor)
         * вернёт Comparator на основе сравнения примитивного типа, полученного с помощью To[тип]Function (параметр метода)
         */
        /** ================ Примеры применения static методов Comparator ====================================
         * ===================================================================================================
         * === nullFirst и nullLast ===
         * сперва рассмотрим "недружественный" к null компаратор */
//        List<Cat> catsList = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));
//        catsList.add(null); // добавляем в коллекцию null
//        Comparator<Cat> compWithNull = (a, b) -> Integer.compare(a.getAge(), b.getAge());
//        Cat minAgeCat1 = Collections.min(catsList, compWithNull);
//        System.out.println(minAgeCat1);
        // выдаст NullPointerException
        // теперь примененме "дружественного" к null метода:
//        Comparator<Cat> compWithNullRes = Comparator.nullsLast(compWithNull);
//        Cat minAgeCat2 = Collections.min(catsList, compWithNullRes);
//        System.out.println(minAgeCat2);
        // Эти методы (nullFirst и nullLast) полезны при сортировке коллекций, в которых есть null
        /** === naturalOrder() и reverseOrder() ===
         * возвращают компаратор, созданный на основании натурального сравнения (Comparable)
         */
//        List<Integer> listInt = List.of(6,7,-2,3,8);
//        Comparator<Integer> compInt = Comparator.<Integer>naturalOrder();
//        // так как параметров нет, подсказываем компилятору сами
//        Integer minInt = Collections.min(listInt, compInt);
//        System.out.println(minInt);
        /** методы comparing ===
         */
//        List<Cat> catsList2 = new ArrayList<>(List.of(cat1, cat2,cat3,cat4,cat5));
//        Function<Cat, String> func6 = (a) -> a.getName();
//        Comparator<String> comp6 = (a, b) -> a.compareTo(b);
//        // имея Function и Comparator для строк, мы можем получить Comparator для котов
//        Comparator<Cat> resultComp6 = Comparator.comparing(func6, comp6);
//        Cat minAgeCat6 = Collections.min(catsList2, resultComp6);
//        System.out.println(minAgeCat6);
        /** методы comparingInt, comparingDouble и comparingLong
         * также вернут компараторы
         */
//        List<Cat> catsList3 = new ArrayList<>(List.of(cat1, cat2,cat3,cat4,cat5));
//        ToIntFunction<Cat> tif = a -> a.getAge();
//        Comparator<Cat> resultComp = Comparator.comparingInt(tif);
//        Collections.sort(catsList3, resultComp);
//        for(Cat cat : catsList3)
//            System.out.println(cat);





    }

    /** Метод для использования Comparator через ссылку на метод */
    public static int catAgeCompare(Cat a, Cat b){
        if(a.getAge()> b.getAge())
            return 1;
        if(b.getAge()<a.getAge())
            return -1;
        return 0;
    }
    
    /** #2.1 */
    public static String catToString(Cat cat){
        return cat.getName();
    }
    /** #2.2 */
    public static int compareStringLength(String a, String b){
        if(a.length() > b.length())
            return 1;
        if(a.length() < b.length())
            return -1;
        return 0;
    }
    

}

/** Реализация Comparator для класса Cat, сравнение по возрасту */
class CatAgeComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.getAge()> o2.getAge()){
            return 1;
        }
        if(o1.getAge()<o2.getAge()){
            return -1;
        }
        return 0;
    }
}

// Ссылка:
// https://www.youtube.com/watch?v=A-yrukWsGDg&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=16