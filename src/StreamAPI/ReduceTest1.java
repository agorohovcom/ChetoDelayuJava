package StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        // reduce
        // пример 1
        int result = list.stream().reduce( (accumulator, element) ->
                               accumulator*element).get();
        System.out.println(result);       // 960
        // переменной accumulator присваивается 1 элемент коллецкии,
        // element - второй. затем выполняется метод с остальными элементами
        // reduce() возвращает Optional, поэтому нужен метод get()

        // пример 2
        int result2 = list.stream().reduce( 1, (accumulator, element) ->
                accumulator*element);
        System.out.println(result2);        // 960
        // в таком случае первым значением accumulator будет 1,
        // а element - первый элемент коллекции. такой reduce()
        // возвратит нам не Optional, а сразу int

        // пример 3
        List<String> list3 = new ArrayList<>();
        list3.add("privet");
        list3.add("kak dela?");
        list3.add("OK");
        list3.add("poka");
        String result3 = list3.stream().reduce((a, e) ->
                a + " " + e).get();
        System.out.println(result3);        // privet kak dela? OK poka




        // Optional
//        Optional<Integer> o = list.stream().reduce( (accumulator, element) ->
//                accumulator*element);
//        if(o.isPresent()){
//            System.out.println(o.get());
//        }
//        else
//            System.out.println("Not present");
    }
}
