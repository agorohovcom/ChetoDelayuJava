package Sort;

import java.util.Date;

public class InsertionSort extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ВСТАВКАМИ";

    public static void sort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "вставками"
        int j;
        for (int i = 1; i < array.length; i++) {
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
        // выводим результат в консоль
        checkAndResultToConsole(array, NAME, start);
    }

}
