package RegEx;

import java.util.Arrays;

public class RegexMatchesAndSplitExample1 {
    public static void main(String[] args) {
        String s =
                "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, " +
                "email: vivanov@mail.ru, Postcode: AA99, Phone Number: +123456789;" +
                "Denisenko Zidan, Litva, Rakulin, Bibuba street, 15, Flat 38, " +
                "email: zi.zi@list.ru, Postcode: BB88, Phone Number: +874589632;" +
                "Chu Li, Krakozhya, Tarasvill, Guberniev street, 43, Flat 444, " +
                "email: zh-izha@lol.ru, Postcode: CC77, Phone Number: +547856985;";

        String s2 = "zh-izha@lol.ru";
        boolean result = s2.matches("[\\w|\\-|\\.]+@\\w+\\.\\w{2,4}");
        System.out.println(result);     // true

        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));
    }
}
