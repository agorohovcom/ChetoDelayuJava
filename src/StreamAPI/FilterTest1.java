package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterTest1 {
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

        // filter()
        List<Student> studentsAfterFilter =
                students = students.stream().filter(element ->
                element.getAge() > 22 && element.getAvgRage() < 7.2)
                .collect(Collectors.toList());
        System.out.println(studentsAfterFilter);

        System.out.println("--------------------------");

        // Можно создать стрим не из коллекции, а с нуля
        Stream<Student> myStream = Stream.of(st1, st2, st3, st4, st5);
    }
}

class Student{
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgRage;

    public Student(String name, char sex, int age, int course, double avgRage) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgRage = avgRage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgRage=" + avgRage +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgRage() {
        return avgRage;
    }

    public void setAvgRage(double avgRage) {
        this.avgRage = avgRage;
    }
}