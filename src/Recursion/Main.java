package Recursion;

public class Main {
    public static void main(String[] args) {
        rec1(1);        // 1 2 4 8 16
        System.out.println();
        rec2(1);        // 16 8 4 2 1
    }
    public static void rec1(int n){
        System.out.print(n + " ");
        if(n < 15){
            rec1(n * 2);
        }
    }
    public static void rec2(int n){
        if(n < 15){
            rec2(n * 2);
        }
        System.out.print(n + " ");
    }
}
