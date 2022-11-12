package Collections.List.ArrayList;

import java.util.ArrayList;

public class ArrayListMethods1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        // add()
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        // добавляем элемент в определенный индекс, остальные сдвигаются
        arrayList1.add(1, "Misha");

        for(String s : arrayList1) System.out.print(s + " ");
        System.out.println();

//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList2.add(6);

        // get()
//        System.out.println(arrayList1.get(2));

//        for(int i = 0; i < arrayList1.size(); i++)
//            System.out.println(arrayList1.get(i));

        // set()
        arrayList1.set(1, "Masha");
        System.out.println(arrayList1);

        // remove()  - работает по стандартному equals()
        arrayList1.remove(0);
        System.out.println(arrayList1);

    }
}
