package RegEx;

import java.util.regex.Pattern;

//0-255.0-255.0-255.0-255
public class RegExIPCheckExample1 {
    void checkIP(String ip){
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}" +
                "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
        System.out.println(ip + " is OK? " + Pattern.matches(regex, ip));
    }
    public static void main(String[] args) {
        String ip1 = "255.38.192.99";
        String ip2 = "182.262.91.05";
        RegExIPCheckExample1 regexIP = new RegExIPCheckExample1();
        regexIP.checkIP(ip1);
        regexIP.checkIP(ip2);
    }
}
