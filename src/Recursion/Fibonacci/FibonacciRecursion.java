package Recursion.Fibonacci;

import java.util.Date;

public class FibonacciRecursion {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(fibonacci(7)); // 13
        System.out.println(fibonacci(12)); // 144
        System.out.println(fibonacci(42)); // 267914296

        System.out.println("Затраченное время: " + (new Date().getTime() - date.getTime()) + " миллисекунд."); // 1838
    }

    public static int fibonacci(int n) {
        /**
         * Рекурсивный метод fibonacci должен принимать порядковый номер
         * искомого числа последовательности Фибоначчи и возвращать его значение.
         *
         * Как это работает:
         * Если n>=2, число раскладывается на предыдущие, пока не доходят до 1,
         * затем это всё суммируется.
         * Для n=5:
         * fibonacci (4) + fibonnacci (3) разбивается на:
         * (fibonacci (3) + fibonnacci (2)) + (fibonacci (2) + fibonnacci (1)) разбивается на:
         * (((fibonacci (2) + fibonnacci (1)) + ((fibonacci (1) + fibonnacci (0))) + (((fibonacci (1) + fibonnacci (0)) + 1)) разбивается на:
         * ((((fibonacci (1) + fibonnacci (0)) + 1) + ((1 + 0)) + ((1 + 0) + 1)) разбивается на:
         * (((1 + 0) + 1) + ((1 + 0)) + ((1 + 0) + 1))
         */
        if(n < 2)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
