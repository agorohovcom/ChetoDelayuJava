package Comparation.TestComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Интерфейс Comparable используется для сравнения объектов,
 * используя ЕСТЕСТВЕННЫЙ порядок
 */
public class TestComparable {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Sidorov", 8542);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting \n" + list);
        Collections.sort(list);
        System.out.println("After sorting \n" + list);
    }
}

class Employee implements Comparable<Employee> {

    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        // Способ 1
//        if (this.id == anotherEmp.id)
//            return 0;
//        else if (this.id < anotherEmp.id)
//            return -1;
//        else
//            return 1;

        // Способ 2
//        return this.id - anotherEmp.id;
        // Способ 3
//        return Integer.compare(this.id, anotherEmp.id);
        // Способ 4
//        return this.name.compareTo(anotherEmp.name);
        // Способ 5: Если имена одинаковые, проверяем по фамилиям
        int result = this.name.compareTo(anotherEmp.name);
        if(result==0)
            result = this.surname.compareTo(anotherEmp.surname);
        return result;
    }
}
