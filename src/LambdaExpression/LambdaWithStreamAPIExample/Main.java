package LambdaExpression.LambdaWithStreamAPIExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Сергей", 38));
        persons.add(new Person("Даша", 7));
        persons.add(new Person("Глаша", 3));
        persons.add(new Person("Саша", 6));
        persons.add(new Person("Анна", 19));

        // ====== Вывод коллекции на экран ======
        // ======================================
        // Обычный метод
//        for (Person d : persons){
//            System.out.println(d);
//        }

        // Используем stream и лямбда-выражение
//        persons.stream().forEach(
//                (Person p ) -> {
//                    System.out.println(p);
//                });

        // Убираем лишнее
//        persons.stream().forEach( p -> System.out.println(p));

        // Делаем через ссылку на метод
//        persons.stream().forEach( System.out::println );

        // Расшифровка ссылки на метод
//        persons.stream().forEach(
//                name -> System.out.println(name)
                /* параметры совпадают */

                /* System.out::println */
//                );

        // ============== Фильтрация ==============
        // ========================================
//        persons.stream().filter( p  -> {
//            return p.getAge() >= 18;
//        } ).forEach( System.out::println );

        // Убираем лишнее
//        persons.stream().
//                filter( p -> p.getAge() >= 18).
//                forEach( System.out::println );

        // ============= Сортировка ===============
        // ========================================
        // Передаём comparator как параметр в sorted()
        // так как наш класс Person не реализует Comparable
//        persons.stream().
//                filter( p -> p.getAge() >= 18).
//                sorted( (p1, p2) -> p1.getName().compareTo(p2.getName()) ).
//                forEach( System.out::println );

        // Вычислить средний возраст совершеннолетних
        // ==========================================
//        int summa = 0;
//        int adultPerson = 0;
//        for(Person p : persons){
//            if(p.getAge() >= 18){
//                summa += p.getAge();
//                adultPerson++;
//            }
//        }
//;
//        double averageAge = (double) summa/adultPerson;
//
//        System.out.println(averageAge);

        // Та же задача декларативным способом
        // ===================================
        double averageAge2 = persons.stream().
                filter( p -> p.getAge() >= 18).
                mapToInt( p -> p.getAge() ).
                average().getAsDouble();

        System.out.println(averageAge2);

    }
}
