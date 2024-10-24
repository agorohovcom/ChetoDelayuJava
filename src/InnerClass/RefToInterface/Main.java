package InnerClass.RefToInterface;

public class Main {
    public static void main(String[] args) {
        Printablee printable = getPrintable("Что это за слово?");
        printable.printSomething();
    }

    public static Printablee getPrintable(String s) {
        class MyPrintSomething implements Printablee {
            private String someString;

            private MyPrintSomething(String someString) {
                this.someString = someString;
            }

            @Override
            public void printSomething() {
                System.out.println(someString);
            }
        }
        return new MyPrintSomething(s);
    }
}

interface Printablee {
    void printSomething();
}
