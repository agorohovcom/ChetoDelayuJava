import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array1 = new int[10];
        for(int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(100);
        }

        System.out.println("Первый массив:");
        for(int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        int[] array2 = array1.clone();
        System.out.println("Клонированный массив:");
        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }
        System.out.println();
    }

}