package BinaryOperations;

public class IntegerRepresentationOfAByte {
    public static void main(String[] args) {
        byte b = -100;
        int unsignedInt = b & 0xFF;

        System.out.println("Byte value: " + b);
        System.out.println("Unsigned Int value: " + unsignedInt);
    }
}
