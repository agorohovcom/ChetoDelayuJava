package LambdaExpression.FunctionalInterfaces.Comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /** Функциональный интерфейс Comparable<T> устанавливает отношение полного
         * порядка для объектов класса, который его реализует. Это отношение порядка называется
         * естественным порядком (natural ordering), а метод compareTo() - естественным
         * методом сравнения (natural comparison method).
         * Comparable должен реализовываться именно тем классом, объекты которого нужно сравнить.
         *
         * Замечания и рекомендации. Желательно, чтобы:
         * 1. a.equals(b)==thue -> a.compareTo(b)==0
         * 2. a.compareTo(b)==0 -> a.equals(b)==true
         * 3. a.compareTo(b)!=0 -> a.equals(b)==false
         * 4. Если параметр метода compareTo равен null, должно быть возбуждено исключение
         * NUllPointerException, даже если equals при этом возвращает false. */

        /** ======== Абстрактный метод compareTo() ========
         * ================================================
         * Выполняет сравнение с объектом по ссылке, используемой в качестве параметра.
         * Если объект больше - возвращает положительное число.
         * Если объект меньше - отрицательное. Если равны - 0. */

        Cat a = new Cat("Umka", 12);
        Cat b = new Cat("Luska", 5);
        Cat c = new Cat("Kuzia", 2);

        Cat d = new Cat("Umka", 12);
        Cat e = new Cat("Barsic", 12);

        System.out.println(sgn(a.compareTo(b)) == -sgn(b.compareTo(a)));                            // true
        System.out.println((a.compareTo(b) > 0 && b.compareTo(c) >0 && a.compareTo(c) > 0));        // true
        System.out.println(a.compareTo(d) == 0 && (sgn(a.compareTo(c)) == sgn(d.compareTo(c))));    // true
        /** Проверяем согласованность с equals() */
        System.out.println(a.equals(d) == true && a.compareTo(d) == 0);                             // true
        System.out.println(a.equals(b) == false && a.compareTo(b) != 0);                            // true
        System.out.println(a.equals(e) == false && a.compareTo(e) != 0);                            // true

        /** ====================================================================================
         * ==================================================================================== */

        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 5);
        Cat cat5 = new Cat("Kuzia", 2);
        Cat[] cats = new Cat[]{cat1,cat2,cat3,cat4,cat5};

        for(Cat cat : cats){
            System.out.println(cat);
        }
        System.out.println();

        Arrays.sort(cats);
        for(Cat cat : cats){
            System.out.println(cat);
        }
    }

    public static int sgn(int x){
        if(x>0)
            return 1;
        else if(x<0)
            return -1;
        return 0;
    }
}

// Видео:
// https://www.youtube.com/watch?v=Ig_fz9q47S8&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=18&ab_channel=OleksandrTsymbaliuk
