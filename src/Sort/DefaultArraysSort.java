package Sort;

import java.util.Arrays;
import java.util.Date;

public class DefaultArraysSort extends SortUtility{
    private final static String NAME = "СТАНДАРТНАЯ СОРТИРОВКА (Arrays.sort())";

    public static void sort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "вставками"
        Arrays.sort(array);
        // выводим результат в консоль
        checkAndResultToConsole(array, NAME, start);
    }

}
