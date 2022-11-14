package Collections.List.Stack;

import Stack_and_Queue.SimpleStack;
import Stack_and_Queue.Stack;

/**
 * Stack - устаревший synchronized класс,
 * наследуется от Vector, испольхует принцип LIFO.
 * Не рекомендован к ипользованию.
 */
public class StackExample1 {
    static void abc1(){
        System.out.println("abc1 starts");
        System.out.println("abc1 ends");
    }
    static void abc2(){
        System.out.println("abc2 starts");
        abc1();
        System.out.println("abc2 ends");
    }
    static void abc3(){
        System.out.println("abc3 starts");
        abc2();
        System.out.println("abc3 ends");
    }

    public static void main(String[] args) {
        System.out.println("main starts");
        abc3();
        System.out.println("main ends");

        // вывод в консоль:
//        main starts
//        abc3 starts
//        abc2 starts
//        abc1 starts
//        abc1 ends
//        abc2 ends
//        abc3 ends
//        main ends
    }
}
