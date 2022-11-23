package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("OK");
        list.add("poka");
        System.out.println(list);

//        for(int i = 0; i < list.size(); i++){
//            list.set(i, String.valueOf(list.get(i).length()));
//        }

        // [6, 9, 2, 4]
        List<Integer> list2 = list.stream().map(element -> element.length())
                .collect(Collectors.toList());
        System.out.println(list2);


        // [5, 3, 1, 8, 1]
        int[] array = {5, 9, 3, 8, 1};
        //
        array = Arrays.stream(array).map(element -> {
           if(element%3 == 0){
               element = element / 3;
           }
           return element;
        }).toArray();
        System.out.println(Arrays.toString(array));


        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("OK");
        set.add("poka");
        System.out.println(set);

        // [6, 9, 2, 4]
        Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
//        List<Integer> list3 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(set2);
    }
}
