package Collections.Set;

import java.util.Objects;
import java.util.TreeSet;

/**
 * Классы, объекты которых используются в TreeSet, должны
 * поддерживать Comparable, или в конструкторе нужно указать Comparator.
 * equals() и hashCode() можно не переопределять, так как это дерево.
 */
public class TreeSetExample2 {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student st1 = new Student("Zaur", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 3);
        Student st5 = new Student("Olga", 4);
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        System.out.println(treeSet);

        // first() - первый элемент
        System.out.println(treeSet.first());

        // last() - последний элемент
        System.out.println(treeSet.last());

        Student st6 = new Student("Oleg", 2);
        Student st7 = new Student("Ivan", 4);

        // headSet() - все элементы до элемента
        System.out.println(treeSet.headSet(st6));

        // tailSet() - все элементы равные и после элемента
        System.out.println(treeSet.tailSet(st6));

        // subSet() - выдает множетво между элементами
        // с первого параметра включительно до второго не включительно
        System.out.println(treeSet.subSet(st6, st7));

//        System.out.println(st3.equals(st6));
//        System.out.println(st3.hashCode() == st6.hashCode());

    }
}

class Student implements Comparable<Student>{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student o) {
        return this.course - o.course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}