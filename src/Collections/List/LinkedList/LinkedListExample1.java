package Collections.List.LinkedList;

import java.util.LinkedList;

/**
 * LinkedList когда стоит использовать:
 * - невелико кол-во операций get()
 * - велико кол-во операций add() и remove()
 * (особенно когда элементы в начале и конце коллекции)
 */
public class LinkedListExample1 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 3);
        Student st2 = new Student("Nikolay", 2);
        Student st3 = new Student("Elena", 1);
        Student st4 = new Student("Petr", 4);
        Student st5 = new Student("Mariya", 3);

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(st1);
        studentLinkedList.add(st2);
        studentLinkedList.add(st3);
        studentLinkedList.add(st4);
        studentLinkedList.add(st5);

        System.out.println("LinkedList = " + studentLinkedList);
        System.out.println(studentLinkedList.get(2));

        Student st6 = new Student("Zaur", 3);
        Student st7 = new Student("Igor", 4);
        studentLinkedList.add(st6);
        System.out.println("LinkedList = " + studentLinkedList);
        studentLinkedList.add(1, st7);
        System.out.println("LinkedList = " + studentLinkedList);

        // remove() - не удаляет объект из памяти, а меняет ссылки в листе
        studentLinkedList.remove(3);
        System.out.println("LinkedList = " + studentLinkedList);
    }
}

class Student{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                "', course='" + course +
                "'}";
    }
}
