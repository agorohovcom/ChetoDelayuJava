package Random;

public class Main {
    public static void main(String[] args) {

        int min = 1;
        int max = 1000;

        for(int i = 0; i < 300; i++){
            System.out.println( (int) (min + (Math.random() * (max - min + 1))));
        }
    }
}
