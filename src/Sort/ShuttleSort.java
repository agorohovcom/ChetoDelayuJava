package Sort;

import java.util.Arrays;
import java.util.Date;

public class ShuttleSort extends SortUtility {
    private final static String NAME = "ЧЕЛНОЧНАЯ СОРТИРОВКА";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем алгоритм челночной сортировки
        shuttleSort(array);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    /** АЛГОРИТМ ЧЕЛНОЧНОЙ СОРТИРОВКИ */
    private static void shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                // меняем элементы массива местами
                swap(array, i, i - 1);
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (array[j] < array[j - 1]) {
                        // меняем элементы массива местами
                        swap(array, j, j - 1);
                    } else break;
                }
            }
        }
    }
}
