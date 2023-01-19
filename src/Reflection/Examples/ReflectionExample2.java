package Reflection.Examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class employeeClass = Class.forName("Reflection.Examples.Employee");

        // устаревший метод создать объект
//        Employee o = (Employee) employeeClass.newInstance();
//        System.out.println(o);

        // создание объекта через конструктор
//        Constructor constructor1 = employeeClass.getConstructor();
//        Object obj1 = constructor1.newInstance();

        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Employee emp1 = constructor1.newInstance();

        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj2 = constructor2.newInstance(5, "Zaur", "IT");
        System.out.println(obj2);

        Method method = employeeClass.getMethod("setSalary", double.class);
        method.invoke(obj2, 800.88);
        System.out.println(obj2);


    }
}
