package InnerClass;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        System.out.println();
        // =============================================

        Sequence sequence2 = new Sequence(5);
        for (int i = 0; i < 5; i++) {
            sequence2.add(Integer.toString(new Random().nextInt(50)));
        }
        Selector selector2 = sequence2.selector();
        while (!selector2.end()) {
            System.out.print(selector2.current() + " ");
            selector2.next();
        }
    }
}