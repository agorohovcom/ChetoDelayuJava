package NestedClasses.AnonymousClass;

/**
 * Анонимные классы не имеют имени.
 * Anonymous класс - это одновременно объявление класса и
 * создание объекта.
 * В анонимных классах невозвожно написать конструктор.
 * Анонимный класс может обращаться даже к private элементам
 * внешнего класса.
 * Lambda expressions - это краткая форма для написания
 * анонимных классов.
 */
public class AnonymousClass1 {
    private int x = 5;

    public static void main(String[] args) {
        MathInterface m = new MathInterface() {
            // сюда пишем что угодно, как в обычном классе
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };

        MathInterface m2 = new MathInterface() {
            @Override
            public int doOperation(int a, int b) {
                AnonymousClass1 ac = new AnonymousClass1();
                return a * b * ac.x;
                // или так
//                return a * b * new AnonymousClass1().x;
            }
        };

        MathClass m3 = new MathClass();

        System.out.println(m.doOperation(3, 6));
        System.out.println(m2.doOperation(3, 6));
        System.out.println(m3.doOperation(3, 6));
        System.out.println(new MathClass().doOperation(6, 54));

    }
}

interface MathInterface{
    int doOperation(int a, int b);
}

class MathClass{
    int doOperation(int a, int b){
        return a + b;
    }
}