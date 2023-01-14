package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexExExample2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("[ABC]");    // создаём шаблон
        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)");
//        Pattern pattern1 = Pattern.compile("\\Aabc");
        Pattern pattern1 = Pattern.compile("ch\\Z");

        Matcher matcher = pattern1.matcher(s1);               // ищем шаблон и передаём результат объекту Matcher

        while (matcher.find()){                               // ищем совпадения
            System.out.println("Position: " +
                    matcher.start() + " " +
                    matcher.group());
        }
    }
}
