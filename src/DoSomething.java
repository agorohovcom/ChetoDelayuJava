import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class DoSomething {
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(4));
        while (s.hasNext())
            System.out.println(s.next());
    }
}

class RandomWords implements Readable{
    private static Random rand = new Random(47);
    private static final char[] capitals =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels =
            "aeiou".toCharArray();
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if(count--==0){
            return -1;
        }
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for(int i = 0; i < 4; i++){
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10;
    }
}