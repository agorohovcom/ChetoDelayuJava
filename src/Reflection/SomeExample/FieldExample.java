package Reflection.SomeExample;

import jdk.jfr.Description;

// import javafx.beans.NamedArg;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// Ссылка: https://vertex-academy.com/tutorials/ru/reflection-api-v-java-class-field/
public class FieldExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         * Класс Field предоставляет возможность:
         *
         * получить значение поля, его тип, имя а так же модификаторы поля
         * получить список аннотаций, класс, в котором объявлено поле и другую информацию
         * установить новое значение в поле, даже если оно объявлено как private
         */

        /**
         * Получение значения переменной
         * Для того, чтобы получить значение из класса Field существуют методы getByte(), getShort(), getInt(), getLong(), getFloat(), getDouble(), getChar(), getBoolean() и get(). Как вы уже догадались, первые 8 методов существуют для получения примитивов, а последний для получения объектов.
         */

        // Пример 1 Получение значения public переменной
        Car car1 = new Car(500, "1233");
        Class<? extends Car> carClass1 = car1.getClass();
        Field serialNumberField1 = carClass1.getDeclaredField("serialNumber");

        String serialNumberValue = (String) serialNumberField1.get(car1);        // указываем из какого объекта мы хотим получить значение
        System.out.println(serialNumberValue); //output: 1233

        // Пример 2 Получение значения private переменной
        // Перед вызовом метода getInt() необходимо вызвать метод setAccessible(true)
        Car car2 = new Car(500, "1233");
        Class<? extends Car> carClass2 = car2.getClass();
        Field horsepowerField2 = carClass2.getDeclaredField("horsepower");

        horsepowerField2.setAccessible(true);
        int horsepowerValue2 = horsepowerField2.getInt(car2);
        System.out.println(horsepowerValue2);

        // Пример 3 Получение имени, типа и модификаторов переменной
        // Метод getModifiers() возвращает все модификаторы метода в битовом представлении. Для работы с ним необходимо воспользоваться методами класса Modifier
        Car car3 = new Car(500, "1233");
        Class<? extends Car> carClass3 = car3.getClass();
        Field horsepowerField3 = carClass3.getDeclaredField("horsepower");

        int modifiers3 = horsepowerField3.getModifiers();

        System.out.println(Modifier.isPrivate(modifiers3));     // output: true
        System.out.println(Modifier.isFinal(modifiers3));       // output: false

        /**
         * ===== АННОТАЦИИ =====
         */

        // Пример 4 Получение аннотаций переменной
        // Для получения аннотаций переменной существуют методы : getAnnotations() и getDeclaredAnnotations(), getAnnotationsByType() и getDeclaredAnnotationsByType(), getAnnotation() и getDeclaredAnnotation()
        // Но, пары методов getAnnotations() и getDeclaredAnnotations(), getAnnotationsByType() и getDeclaredAnnotationsByType(), getAnnotation() и getDeclaredAnnotation() делают одно и то же.
        Car car4 = new Car(500, "1233");
        Class<? extends Car> carClass4 = car4.getClass();
        Field horsepowerField4 = carClass4.getDeclaredField("horsepower");

        // getAnnotations() возвращает массив аннотаций метода
        Annotation[] annotations4 = horsepowerField4.getAnnotations();
        for(Annotation a : annotations4){
            System.out.println(a);
        }       //output: @jdk.jfr.Description(value="the power of an engine")

        // getAnnotation() возвращает аннотацию по типу
        Description descriptionAnnotation4 = horsepowerField4.getAnnotation(Description.class);
        System.out.println(descriptionAnnotation4); //output: @jdk.jfr.Description(value="the power of an engine")

        // getAnnotationsByType() возвращает массив аннотаций по типу. Метод был добавлен в Java 8 вместе с @Repeatable аннотациями
        Annotation[] annotationsByType = horsepowerField4.getAnnotationsByType(Description.class);
        for(Annotation a : annotationsByType){
            System.out.println(a);
        }   //output: @jdk.jfr.Description(value="the power of an engine")

        // Пример 5 Получение дополнительных данных
        Car car5 = new Car(500, "1233");
        Class<? extends Car> carClass5 = car5.getClass();
        Field horsepowerField5 = carClass5.getDeclaredField("horsepower");

        Class<?> declaringClass5 = horsepowerField5.getDeclaringClass(); // возвращает класс, в котором объявлено поле
        System.out.println(declaringClass5); //output: class com.vertex.reflection.Car

        boolean enumConstant5 = horsepowerField5.isEnumConstant(); //возвращает true, если поле является значением перечисления
        System.out.println(enumConstant5); //output: false

        boolean synthetic5 = horsepowerField5.isSynthetic(); // возвращает true, если метод синтетический (генерируется JVM)
        System.out.println(synthetic5); //output: false

        boolean canAccess5 = horsepowerField5.canAccess(car5); // возвращает true, если к полю есть доступ (к примеру, оно не приватное)
        System.out.println(canAccess5); //output: false

        boolean isPresent5 = horsepowerField5.isAnnotationPresent(Description.class);// возвращает true, если такая аннотация присутствует на поле
        System.out.println(isPresent5); //output: false

        // System.out.println(horsepowerField5.isAnnotationPresent(NamedArg.class)); //output: true

        /**
         * ===== ИЗМЕНЕНИЕ ЗНАЧЕНИЯ ПЕРЕМЕННЫХ =====
         * Для этого у нас есть методы setByte(), setShort(), setInt(), setLong(), setFloat(), setDouble(), setChar(), setBoolean() и set(), который принимает ссылочные типы данных.
         */

        // Пример 6 Изменение значения public переменной
        Car car6 = new Car(500, "1233");
        Class<? extends Car> carClass6 = car6.getClass();
        Field serialNumberField6 = carClass6.getField("serialNumber");

        System.out.println("Before change:" + serialNumberField6.get(car6));
        // даём разрешение на изменение final переменной
        serialNumberField6.setAccessible(true);
        serialNumberField6.set(car6, "37U1");
        System.out.println("After change:" + serialNumberField6.get(car6));

        // Пример 7 Изменение значения private переменной
        // Как и в случае с получением значение private переменной или изменением final переменной, перед использованием одного из методов set необходимо вызвать метод setAccessible(true)
        Car car7 = new Car(500, "1233");
        Class<? extends Car> carClass7 = car7.getClass();
        Field horsepowerField7 = carClass7.getDeclaredField("horsepower");

        horsepowerField7.setAccessible(true);
        System.out.println("Before change:" + horsepowerField7.getInt(car7));
        horsepowerField7.setInt(car7, 751);
        System.out.println("After change:" + horsepowerField7.getInt(car7));
    }
}
