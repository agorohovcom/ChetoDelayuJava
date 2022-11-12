package Collections.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods5 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");
        System.out.println("ArrayList = " + arrayList1);

//        ArrayList<String> arrayList2 = new ArrayList<>();
//        arrayList2.add("Ivan");
//        arrayList2.add("Maria");
//        arrayList2.add("Igor");

        // removeAll() - удаляет из листа 1 элементы, которые есть в листе 2
//        arrayList1.removeAll(arrayList2);
//        System.out.println(arrayList1);

        // retainAll() - оставляет в листе 1 только те элементы, которые еть в листе 2

        // containsAll() - содержит ли лист 1 все элементы из листа 2
//        boolean result = arrayList1.containsAll(arrayList2);
//        System.out.println(result);

        // subList() - создаёт отрывок листа
        // с 1 включительно по 4 не включительно
//        List<String> myList = arrayList1.subList(1, 4);
//        System.out.println("Sublist = " + myList);
        // myList не сузествует отдельно от arrayList1
//        myList.add("Fedor");
        // Fedor добавится не только в саблист, но и в оригинал
//        System.out.println("Sublist = " + myList);
//        System.out.println("ArrayList = " + arrayList1);

//        arrayList1.add("Sveta");
//        System.out.println("ArrayList = " + arrayList1);
        // после изменения оригинала использование саблиста выдаст ConcurrentModificationException
//        System.out.println("Sublist = " + myList);

        // toArray()
        Object[] array = arrayList1.toArray();
        // размер массива можно указать 0, компилятор сам поправит
        String[] array2 = arrayList1.toArray(new String[0]);
        for(String s : array2) System.out.print(s + " ");
        System.out.println();
    }
}
