public class LeetCodeWars {
        public static boolean isPalindrome(int x) {
            char[] chars = Integer.toString(x).toCharArray();
            boolean b = true;
            int start = 0;
            int end = chars.length - 1;
            for (int i = chars.length / 2; i > 0; i--) {
                if (chars[start] == chars[end]) {
                    start++;
                    end--;
                } else {
                    b = false;
                    break;
                }
            }
                return b;
        }


    public static void main(String[] args) {

        System.out.println(LeetCodeWars.isPalindrome(123621));

    }
}
