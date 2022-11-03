package Sort;

import java.util.Date;

public class InsertionSort extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ВСТАВКАМИ";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем алгоритм сортировки
        insertionSort(array);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    /** АЛГОРИТМ СОРТИРОВКИ ВСТАВКАМИ */
    private static void insertionSort(int[] array){
        int j;
        for (int i = 1; i < array.length; i++) {
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
    }
}
