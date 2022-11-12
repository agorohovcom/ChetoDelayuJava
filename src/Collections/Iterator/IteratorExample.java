package Collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        // создаём итератор
        // с помощью итератора можно изменять коллекцию (в отличии от for-each)
        Iterator<String> iterator = arrayList1.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(arrayList1);

        // самые необходимые методы итераторв
//        Iterator<DataType> iter = aL.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }


    }
}
