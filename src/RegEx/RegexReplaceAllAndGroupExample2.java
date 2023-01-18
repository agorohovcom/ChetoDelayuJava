package RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplaceAllAndGroupExample2 {
    public static void main(String[] args) {
        String myString = "65435789654567861212324;" +
                "45457878986503044565678;" +
                "45654366789745650908675;" +
                "45457767543467880502547";
//        Pattern pattern = Pattern.compile("\\d{23}");
        Pattern pattern = Pattern.compile(
                "(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(myString);

//        while (matcher.find()){
//            System.out.println(matcher.group(7));
//        }
        // Output
//        324
//        678
//        675
//        547

        while (matcher.find()){
            System.out.println(matcher.group());
        }
        // Output:
//        65435789654567861212324
//        45457878986503044565678
//        45654366789745650908675
//        45457767543467880502547

        String myNewString = matcher.replaceAll("" +
                "$5/$6 $1 $2 $3 $4 ($7)");

        System.out.println(myNewString);
        // Output:
//        12/12 6543 5789 6545 6786 (324);45/65 4545 7878 9865 0304 (678);09/08 4565 4366 7897 4565 (675);05/02 4545 7767 5434 6788 (547)

    }
}
