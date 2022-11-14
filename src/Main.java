import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(67);
        list.add(67546);
        list.add(354);
        list.add(6);
        System.out.println(list);

        list.set(2, null);
        System.out.println(list);
    }
}