package Collections.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample1 {
    public static void main(String[] args) {
        // создаём ArrayList с массивом на 10 элементов (capacity == 0)
        ArrayList<String> arrayList1 = new ArrayList</*String*/>();     // String можно не указывать
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
//        arrayList1.add(50);       // так нельзя из-за дженерика String
        System.out.println(arrayList1);

        // создаём ArrayList с массивом на 200 элементов (задаём capacity вручную)
        ArrayList<String> arrayList2 = new ArrayList<>(200);
        arrayList2.add("Zaur");
        arrayList2.add("Ivan");

        // создаём ArrayList через интерфейс List
        List<String> arrayList3 = new ArrayList</*String*/>();     // String можно не указывать

        // создаём ArrayList и помещаем в него другой ArrayList
        ArrayList<String> arrayList4 = new ArrayList<>(arrayList1);
        System.out.println(arrayList4);
        System.out.println(arrayList1 == arrayList4);   // false, потому что это разные объекты
    }
}
