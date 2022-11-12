package Collections.List.ArrayList;

import java.util.ArrayList;

public class ArrayListMethods3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("???");

        // addAll()
//        arrayList1.addAll(arrayList2);
        arrayList1.addAll(1, arrayList2);
        System.out.println(arrayList1);

        // clear()
//        arrayList1.clear();
//        System.out.println(arrayList1);

        // indexOf() - работает по стандартному equals()
        System.out.println(arrayList1.indexOf("Ivan"));
        // lastIndexOf() - работает по стандартному equals()
        System.out.println(arrayList1.lastIndexOf("Ivan"));

        // size()
        System.out.println(arrayList1.size());

        // isEmpty()
        arrayList2.clear();
        System.out.println(arrayList2.isEmpty());

        // contains() - работает по стандартному equals()
        System.out.println(arrayList1.contains("Kolya"));
        System.out.println(arrayList1.contains("Maria"));

        // toString - можно переопределить
        System.out.println(arrayList1.toString());
    }
}
