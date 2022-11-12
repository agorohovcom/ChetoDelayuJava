package Collections.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods6 {
    public static void main(String[] args) {
        // ListOf() - иммутабельный объект, не изменяются и не содержат null
        List<Integer> list1 = List.of(3, 8, 13);
        System.out.println(list1);
        // при попытке изменить list1 получим UnsupportedOperationException
//        list1.add(100);

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        System.out.println(arrayList1);

        // List.copyOf() - иммутабельный объект, не изменяются и не содержат null
        List<String> list2 = List.copyOf(arrayList1);
        System.out.println(list2);
    }
}
