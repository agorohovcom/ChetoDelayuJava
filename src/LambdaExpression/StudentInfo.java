package LambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class StudentInfo {

    void testStudents(ArrayList<Student> a1, Predicate<Student> pr) {
        for (Student s : a1)
            if (pr.test(s))
                System.out.println(s);
    }
}

class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();

//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.course - s2.course;
//            }
//        });

//        Collections.sort(students, (stud1, stud2) -> stud1.course - stud2.course);
//        System.out.println(students);
//
//        System.out.println("-------------------");

//        info.testStudents(students, (Student s) -> {
//            return s.avgRage > 8;
//        });
//
//        info.testStudents(students, p -> p.avgRage > 8);

        Predicate<Student> p1 = student -> student.avgRage > 7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';

        info.testStudents(students, p1.and(p2));
        System.out.println("-------------------");
        info.testStudents(students, p1.or(p2));
        System.out.println("-------------------");
        info.testStudents(students, p1.negate());

        System.out.println("-------------------");
        info.testStudents(students, (Student s) -> {
            return s.age < 30;
        });

//        System.out.println("-------------------");
//        info.testStudents(students, (Student s) -> {
//            return s.age > 20 && s.avgRage < 9.5 && s.sex == 'f';
//        });
    }
}

//interface StudentChecks {
//    boolean check(Student s);
//}

//class CheckOverGrade implements StudentChecks {
//    @Override
//    public boolean check(Student s) {
//        return s.avgRage > 8;
//    }
//}