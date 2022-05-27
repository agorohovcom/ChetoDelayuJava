package Random;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());

//        for (int i = 0; i < 20; i++) {
//            System.out.println(getPassword().toString());
//        }

    }

    public static ByteArrayOutputStream getPassword() {
        List<Character> list = new ArrayList<>();

        // определяем кол-во маленьких букв от 1 до 6
        int lowCaseLetters = (int) (1 + Math.random() * 6);
        // определяем кол-во больших букв от 1 до 8-lowCaseLetters-1
        int uppCaseLetters = (int) (1 + Math.random() * (7 - lowCaseLetters));
        // определяем кол-во цифр
        int numbers = 8 - lowCaseLetters - uppCaseLetters;

        for (int i = 0; i < lowCaseLetters; i++) {
            list.add((char) (97 + Math.random() * (122 - 97 + 1)));
        }
        for (int i = 0; i < uppCaseLetters; i++) {
            list.add((char) (65 + Math.random() * (90 - 65 + 1)));
        }
        for (int i = 0; i < numbers; i++) {
            list.add((char) (48 + Math.random() * (57 - 48 + 1)));
        }

        // перемешиваем ^_^
        Collections.shuffle(list);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for (int i = 0; i < list.size(); i++) {
            bos.write(list.get(i));
        }
        return bos;
    }
}
