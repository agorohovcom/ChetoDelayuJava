package Recursion.Fibonacci;

import java.util.Date;

public class FibonacciRecursionWithMemo {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(fibonacci(7)); // 13
        System.out.println(fibonacci(12)); // 144
        System.out.println(fibonacci(42)); // 267914296

        System.out.println("Затраченное время: " + (new Date().getTime() - date.getTime()) + " миллисекунд."); // 1
    }

    public static int fibonacci(int n) {
        return fibonacciMemo(n, new int[n + 1]);
    }

    private static int fibonacciMemo(int i, int[] memo) {

        if (i == 0 || i == 1) {
            return i;
        }

        if (memo[i] == 0) {
            memo[i] = fibonacciMemo(i - 1, memo) + fibonacciMemo(i - 2, memo);
        }
        return memo[i];
    }
}
