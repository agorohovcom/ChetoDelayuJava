package Remote.DynamicProxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        // Создаём оригинальный объект класса Man
        Man grishka = new Man("Гриша", 32, "Комарососск", "Гренландия");

        // Получаем загрузчик класса у нашего объекта grishka
        ClassLoader grishkaClassLoader = grishka.getClass().getClassLoader();

        // Получаем все интерфейсы, которые реализует объект grishka
        Class [] interfaces = grishka.getClass().getInterfaces();

        // Создаём прокси объекта grishka
        Person proxyGrishka = (Person) Proxy.newProxyInstance(
                grishkaClassLoader,
                interfaces,
                new PersonInvocationHandler(grishka));

        // Вызываем у прокси объекта proxyGrishka методы нашего оригинального объекта grishka
        proxyGrishka.introduce(grishka.getName());
        proxyGrishka.sayAge(grishka.getAge());
    }
}