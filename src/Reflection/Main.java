package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        /**
         * Как получить Класс класса с помощью Рефлексии
         */
        // Получить Класс класса - способ 1
        try {
            Class<?> carClass1 = Class.forName("Reflection.Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Получить Класс класса - способ 2
        Car car = new Car();
        Class<? extends Car> carClass2 = car.getClass();

        // Получить Класс класса- способ 3
        Class<Car> carClass3 = Car.class;

        /**
         * Как получить информацию о переменных класса с помощью Рефлексии?
         * Получить информацию о переменных класса можно с помощью методов
         * getDeclaredFields(),  getDeclaredField() и getFields(), getField().
         */
        // Пример 1 getDeclaredFields() - метод возвращает
        // все объявленные переменные в классе
        Class<Car> carClass4 = Car.class;
        Field[] declaredFields = carClass4.getDeclaredFields();
        for(Field field : declaredFields){
            System.out.println(field);
        }

        // Пример 2 getDeclaredField() - метод возвращает
        // переменную по её имени. Если переменной с таким именем нет,
        // то метод выбросит checked NoSuchFieldException.
        Class<Car> carClass5 = Car.class;
        try {
            Field horsepowerField = carClass5.getDeclaredField("horsepower");
            System.out.println(horsepowerField);
            // Field blaBlaField = carClass5.getDeclaredField("bla_bla");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // Пример 3 getFields() - в отличии от метода getDeclaredFields(),
        // метод getFields() возвращает только public переменные
        Class<Car> carClass6 = Car.class;
        Field[] fields = carClass6.getFields();
        for(Field field : fields){
            System.out.println(field);
        }

        // Пример 4 getField() - по аналогии с методом getFields(),
        // метод getField() возвращает только public переменные.
        // Даже если поле с таким именем есть, но оно не публичное,
        // метод getField() бросит NoSuchFieldException
        Class<Car> carClass7 = Car.class;
        try {
            Field serialNumberField = carClass7.getField("serialNumber");
            System.out.println(serialNumberField);
            // Field horsepowerField = carClass7.getField("horsepower");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        /**
         * Как получить информацию о методах в классе с помощью Рефлексии?
         * Получить информацию о методах класса можно с помощью методов
         * getDeclaredMethods(), getDeclaredMethod(), getMethods(), getMethod() и getEnclosingMethod().
         */
        // Пример 1 getDeclaredMethods() - метод возвращает все объявленнные методы в классе
        Class<Car> carClass8 = Car.class;
        Method[] declaredMethods = carClass8.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        // Пример 2 getDeclaredMethod() - метод getDeclaredMethod(String name, Class<?>... parameterTypes)
        // принимает имя и var-args с типами параметров метода.
        // Если такого метода в классе нет, мы получим checked NoSuchMethodException.
        Class<Car> carClass10 = Car.class;
        try {
            Method printSerialNumberMethod = carClass10.getDeclaredMethod("printSerialNumber");
            System.out.println(printSerialNumberMethod);

            Method setHorsepowerMethod = carClass10.getDeclaredMethod("setHorsepower", int.class);
            System.out.println(setHorsepowerMethod);

            // carClass10.getDeclaredMethod("dodooooo");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // Пример 3 getMethods() - метод возвращает все public методы класса и
        // public методы его родительского класса/интерфейсов
        Class<Car> carClass11 = Car.class;
        Method[] methods = carClass11.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // Пример 4 getMethod() - как и getMethods(), метод getMethod()
        // возвращает только публичные методы.
        // Если такого метода нет или он не публичный, мы получим NoSuchMethodException.
        Class<Car> carClass12 = Car.class;
        try {
            Method getHorsepowerMethod = carClass12.getMethod("notifyAll");
            System.out.println(getHorsepowerMethod);

            // Method printSerialNumberMethod = carClass12.getMethod("printSerialNumber");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    // Пример 5 getEnclosingMethod() - если класс является локальным или анонимным,
    // метод getEnclosingMethod() возвращает тот метод,
    // в котором этот класс был создан, иначе метод возвращает null.
    public static void anonymousClassExample() {
        Car car = new Car() {
            @Override
            protected void printSerialNumber() {
            }
        };
        Method enclosingMethod = car.getClass().getEnclosingMethod();
        System.out.println(enclosingMethod);
    }
}
