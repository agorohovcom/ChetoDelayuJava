import java.util.*;
import java.util.function.Predicate;

public class Main<T> {
    void doSomething(Collection<T> collection, Predicate<T> pr) {
        for (T i : collection) {
            if (pr.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list1.add(new Random().nextInt(100));
        System.out.println(list1);
        new Main<Integer>().doSomething(list1, i -> i < 50);

        System.out.println("---------------------------------");

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list2.add(Character.toString('А' + new Random().nextInt(32)));
        }
        System.out.println(list2);
        new Main<String>().doSomething(list2, s -> {
            ArrayList<String> list = new ArrayList<>();
            list.add("С");
            list.add("У");
            list.add("К");
            list.add("A");
            list.add("П");
            list.add("Д");
            list.add("Л");
            return list.contains(s);
        });
    }
}








