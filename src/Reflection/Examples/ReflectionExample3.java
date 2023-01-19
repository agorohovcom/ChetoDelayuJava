package Reflection.Examples;

import java.lang.reflect.Field;

public class ReflectionExample3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10, "Zaur", "IT");
        Class employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");

        // открываем доступ к приватному полю
        field.setAccessible(true);
        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);

        // меняем значение приватного поля
        field.set(employee, 1500);
        System.out.println(employee);
    }
}
