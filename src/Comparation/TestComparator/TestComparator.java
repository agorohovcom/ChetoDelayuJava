package Comparation.TestComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Интерфейс Comparator используется для сравнения объектов,
 * используя НЕ ЕСТЕСТВЕННЫЙ порядок
 */
public class TestComparator {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Sidorov", 8542);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting \n" + list);
        Collections.sort(list, new IDComparator());
        System.out.println("After sorting \n" + list);
        Collections.sort(list, new NameComparator());
        System.out.println("After sorting \n" + list);
        Collections.sort(list, new SalaryComparator());
        System.out.println("After sorting \n" + list);
    }
}

class Employee {

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
}

class IDComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Способ 1
        if (emp1.id == emp2.id)
            return 0;
        else if (emp1.id < emp2.id)
            return -1;
        else
            return 1;
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Способ 2
        return emp1.name.compareTo(emp2.name);
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        // Способ 3
        return emp1.salary - emp2.salary;
    }
}