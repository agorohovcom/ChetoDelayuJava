package Reflection;

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
        Field serialNumberField = carClass1.getDeclaredField("serialNumber");

        String serialNumberValue = (String) serialNumberField.get(car1);        // указываем из какого объекта мы хотим получить значение
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

        // Пример 4 Получение аннотаций переменной
        // Для получения аннотаций переменной существуют методы : getAnnotations() и getDeclaredAnnotations(), getAnnotationsByType() и getDeclaredAnnotationsByType(), getAnnotation() и getDeclaredAnnotation()
        // Но, пары методов getAnnotations() и getDeclaredAnnotations(), getAnnotationsByType() и getDeclaredAnnotationsByType(), getAnnotation() и getDeclaredAnnotation() делают одно и то же.
        а тут код пишу такой, но сперва там же надо в кар аннотацию добавить. завтра разберусь, или отложу на потом. ещё не знаю, непонятно, надо ж траву покосить и в колду поиграть
    }
}
