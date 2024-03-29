package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexExExample1 {
    public static void main(String[] args) {
        String s =
                "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, " +
                "email: vivanov@mail.ru, Postcode: AA99, Phone Number: +123456789;" +
                "Denisenko Zidan, Litva, Rakulin, Bibuba street, 15, Flat 38, " +
                "email: zi.zi@list.ru, Postcode: BB88, Phone Number: +874589632;" +
                "Chu Li, Krakozhya, Tarasvill, Guberniev street, 43, Flat 444, " +
                "email: zh-izha@lol.ru, Postcode: CC77, Phone Number: +547856985;";

//        Pattern pattern = Pattern.compile("\\w+");
//        Pattern pattern = Pattern.compile("\\b\\d{2}\\b");
//        Pattern pattern = Pattern.compile("\\+\\d{9}");
//        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w{2,4}");
        Pattern pattern = Pattern.compile("[\\w|\\-|\\.]+@\\w+\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
