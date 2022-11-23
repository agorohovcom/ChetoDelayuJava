package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedTest1 {
    public static void main(String[] args) {
        int [] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};

        // sorted()
        // вариант 1
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));

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

        // вариант 2
        // При сортировке элементов не Comparable нужно
        // в sorted() добавлять реализацию compareTo()
        students = students.stream().sorted((x, y) ->
                x.getName().compareTo(y.getName()))
                .collect(Collectors.toList());
        System.out.println(students);
    }
}