package Collections.Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// проверим строку на палиндром с помощью ListIterator
public class ListIteratorExample {
    public static void main(String[] args) {
        String s = "madam";
        List<Character> list = new LinkedList<>();
        for(char ch : s.toCharArray()){
            list.add(ch);
        }
        // listIterator в параметре принимает начальную позицию
        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseIterator = list.listIterator(list.size());
        boolean isPalindrom = true;
        while(iterator.hasNext() && reverseIterator.hasPrevious()){
            if (iterator.next() != reverseIterator.previous()){
                isPalindrom = false;
                break;
            }
        }
        if(isPalindrom)
            System.out.println("'" + s + "' is palindrom");
        else
            System.out.println("'" + s + "' is NOT palindrom");
    }
}
