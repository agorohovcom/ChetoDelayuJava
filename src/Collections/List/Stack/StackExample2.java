package Collections.List.Stack;

import java.util.Stack;

public class StackExample2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("Zaur");
        stack.add("Misha");
        stack.add("Oleg");
        stack.add("Katya");
        System.out.println(stack);

        // pop() - возвращает последний элемент и удаляет его
        System.out.println(stack.pop());
        System.out.println(stack);

        // isEmpty() - пуст ли stack
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//            System.out.println(stack);
//        }

        // peek() - возвращает верхний элемент, не удаляет
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
