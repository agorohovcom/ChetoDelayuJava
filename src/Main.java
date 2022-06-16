public class Main {
    public static void main(String[] args) {

        System.out.printf("%02x%n", 3544);

        System.out.println(Integer.toHexString(0xFfffF & -65));

        System.out.println("двоичный int -1: " + Integer.toBinaryString(-1));

    }
}