package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntTest1 {
    public static void main(String[] args) {
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

        // mapToInt()
        List<Integer> courses =
                students.stream()
                        .mapToInt(e -> e.getCourse())
                        .boxed()                // конвертирует примитивные типы в ссылочные
                        .collect(Collectors.toList());
        System.out.println(courses);            // [3, 2, 1, 4, 3]
        System.out.println("------------------------------");

        // sum()
        int sum = students.stream().mapToInt(e -> e.getCourse()).sum();
        System.out.println("sum(): " + sum);

        // average()
        double average = students.stream().mapToInt(e -> e.getCourse()).average().getAsDouble();
        System.out.println("average(): " + average);

        // min()
        int min = students.stream().mapToInt(e -> e.getCourse()).min().getAsInt();
        System.out.println("min(): " + min);

        // max()
        int max = students.stream().mapToInt(Student::getCourse).max().getAsInt();
        System.out.println("max(): " + max);
    }
}
