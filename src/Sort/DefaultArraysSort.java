package Sort;

import java.util.Arrays;
import java.util.Date;

public class DefaultArraysSort extends SortUtility{
    private final static String NAME = "СТАНДАРТНАЯ СОРТИРОВКА (Arrays.sort())";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем стандартную сортировку
        Arrays.sort(array);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

}
