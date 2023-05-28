public class LeetCodeWars {
    public int romanToInt(String s) {
        int result = 0;

        switch (s.charAt(0)){
            case 'X': {
                result += 10;
                break;
            }

        }

        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        new LeetCodeWars().romanToInt("XVI");
    }
}