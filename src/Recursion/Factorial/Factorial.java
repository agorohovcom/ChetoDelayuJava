package Recursion.Factorial;

import java.util.Date;

public class Factorial {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(factorial(7)); // 5040
        System.out.println(factorial(12)); // 479001600
        System.out.println(factorial(23)); // 862453760

        System.out.println("Затраченное время: " + (new Date().getTime() - date.getTime()) + " миллисекунд."); // 1
    }

    public static int factorial(int n) {
        if (n < 2){
            return 1;
        }
        else return n * factorial(n - 1);
    }
}
