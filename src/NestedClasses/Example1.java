package NestedClasses;

// класс принадлежит пакету
public class Example1 {
    // 1. статический вложенный класс (static nested class)
    // можно использовать как обычный внешний класс
    static class A{}
    // 2. вложенный класс (inner class)
    class B{}
    void method(){
        // 3. локальный класс (local inner class)
        class C{}
    }
}

// 4. анонимный класс (anonymous class)