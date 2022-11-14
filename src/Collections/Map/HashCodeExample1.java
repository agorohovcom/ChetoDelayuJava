package Collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * При переопределении equals() надо обязательно переопределять и hashcode().
 * Результат hashcode() для одного и того же объекта должен быть всегда одинаковым.
 * Если по equals() два объекта равны, то hashcode() обязательно должен совпадать.
 * Если по equals() два объекта не равны, то hashcode() не обязательно должен быть разным.
 */
public class HashCodeExample1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);

        // без переопределения hashcode выдаст false потому что
        // HashMap и HashSet при поиске и сравнении используют хеширование
        Student st4 = new Student("Zaur", "Tregulov", 3);
        System.out.println("st1.equals(st4)=" + st1.equals(st4));
        boolean result = map.containsKey(st4);
        System.out.println("result=" + result);

        System.out.println("st1.hashCode()=" + st1.hashCode());
        System.out.println("st2.hashCode()=" + st2.hashCode());

        System.out.println("st4.hashCode()=" + st4.hashCode());

        Student st5 = new Student("Igor", "Sidorov", 4);
        System.out.println("st5.hashCode()=" + st5.hashCode());
    }
}

// Отмечаем класс и поля как final, если он используется в качестве ключа HashMap
final class Student implements Comparable<Student>{
    final String name;
    final String surname;
    final int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        // слишком простой вариант, будет много коллизий
//        return name.length() + surname.length() + course;

        // чтобы улучшить, можно умножать на простые числа
//        return name.length()*7 + surname.length()*11 + course*53;

        // стандартный вариант
        return Objects.hash(name, surname, course);
    }

    @Override
    public int compareTo(Student anotherStudent) {
        return anotherStudent.name.compareTo(anotherStudent.name);
    }
}