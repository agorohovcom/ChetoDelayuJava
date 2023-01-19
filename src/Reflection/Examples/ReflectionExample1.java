package Reflection.Examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionExample1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 1 вариант создания объекта класса Class
        Class employeeClass1 = Class.forName("Reflection.Examples.Employee");
        // 2 вариант создания объекта класса Class
//        Class employeeClass2 = Employee.class;
        // 3 вариант создания объекта класса Class
//        Employee emp = new Employee();
//        Class employeeClass3 = emp.getClass();

        // получить поле по имени
        Field someField = employeeClass1.getField("id");
        // получить тип поля
        System.out.println("Type of \"id\" field: " + someField.getType());
        System.out.println("-------------------------------");

        // получить массив полей (кроме приватных)
        Field[] fields = employeeClass1.getFields();
        for (Field f : fields) {
            System.out.println("Type of \"" + f.getName() + "\": " + f.getType());
        }
        System.out.println("-------------------------------");


        // получить все поля, даже приватные
        Field[] allFields = employeeClass1.getDeclaredFields();
        for (Field f : allFields) {
            System.out.println("Type of \"" + f.getName() + "\": " + f.getType());
        }
        System.out.println("-------------------------------");

        // получить метод по имени
        Method someMethod1 = employeeClass1.getMethod("increaseSalary");
        System.out.println("Return type of method \"" + someMethod1.getName() + "\": " + someMethod1.getReturnType());
        System.out.println("Parameter types of method \"" + someMethod1.getName() + "\": " + Arrays.toString(someMethod1.getParameterTypes()));
        System.out.println("-------------------------------");

        Method someMethod2 = employeeClass1.getMethod("setSalary", double.class);
        System.out.println("Return type of method \"" + someMethod2.getName() + "\": " + someMethod2.getReturnType());
        System.out.println("Parameter types of method \"" + someMethod2.getName() + "\": " + Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("-------------------------------");

        // получить все методы класса с унаследованными, но без приватных
        Method[] methods = employeeClass1.getMethods();
        for (Method m : methods) {
            System.out.println("Name of method: " + m.getName() +
                    ", return type: " + m.getReturnType() +
                    ", parameter types: " + Arrays.toString(m.getParameterTypes()));
        }
        System.out.println("-------------------------------");

        // получить все методы класса с переопределенными и приватными, но без унаследованных
        Method[] allMethods = employeeClass1.getDeclaredMethods();
        for (Method m : allMethods) {
            System.out.println("Name of method: " + m.getName() +
                    ", return type: " + m.getReturnType() +
                    ", parameter types: " + Arrays.toString(m.getParameterTypes()));
        }
        System.out.println("-------------------------------");

        // получить только публичные методы
        Method[] publicMethods = employeeClass1.getDeclaredMethods();
        for (Method m : allMethods) {
            if (Modifier.isPublic(m.getModifiers())) {
                System.out.println("Name of method: " + m.getName() +
                        ", return type: " + m.getReturnType() +
                        ", parameter types: " + Arrays.toString(m.getParameterTypes()));
            }
        }
        System.out.println("-------------------------------");

        // получить конструктор
        Constructor someConstructor1 = employeeClass1.getConstructor();
        System.out.println("Constructor has " +
                someConstructor1.getParameterCount() + " parameters" +
                ", their types are " + Arrays.toString(someConstructor1.getParameterTypes()));
        System.out.println("-------------------------------");

        Constructor someConstructor2 = employeeClass1.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor has " +
                someConstructor2.getParameterCount() + " parameters" +
                ", their types are " + Arrays.toString(someConstructor2.getParameterTypes()));
        System.out.println("-------------------------------");

        // получить инфрормацию о всех конструкторах
        Constructor[] allConstructors = employeeClass1.getConstructors();
        for(Constructor c : allConstructors){
            System.out.println("Constructor " + c.getName() +
                    " has " + c.getParameterCount() + " parameters" +
                    ", their types are " + Arrays.toString(c.getParameterTypes()));
        }
        System.out.println("-------------------------------");

        // getDeclaredConstructors - получить приватные конструкторы

    }
}
