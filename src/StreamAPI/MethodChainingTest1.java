package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodChainingTest1 {
    public static void main(String[] args) {
        // пример 1
        int [] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int result = Arrays.stream(array).filter(e -> e%2 == 1)
                .map(e -> {if(e%3==0) e = e/3;  return e;})
                .reduce((a, e) -> a + e)
                .getAsInt();
        System.out.println(result);

        System.out.println("---------------------------------");

        // пример 2
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students.stream().map(element -> {
            element.setName(element.getName().toUpperCase());
            return element;
        })
                .filter(element -> element.getSex()=='f')
                .sorted((x,y) -> x.getAge() - y.getAge())
                .forEach(element -> System.out.println(element));

        // пример 3
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
//        stream1.filter(el -> {
//            // "!!!" не выведется, так как терминального метода нет,
//            // а без него ничего не работает
//            System.out.println("!!!");
//            return el%2==0;
//        });
        // а так "!!!" выведутся
        stream1.filter(el -> {
            // "!!!" не выведется, так как терминального метода нет,
            // а без него ничего не работает
            System.out.println("!!!");
            return el%2==0;
        }).collect(Collectors.toList());
    }
}
