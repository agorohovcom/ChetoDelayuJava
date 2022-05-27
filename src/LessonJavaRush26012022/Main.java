package LessonJavaRush26012022;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        if(age >= 18) {
            System.out.println("Вы уже взрослый");
        }
        else {
            System.out.println("Вы слишком молоды");
        }

    }

}
