package Sort;

import java.util.Date;

public class SelectionSort extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ВЫБОРОМ";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем алгоритм сотрировки "выбором"
        selectionSort(array);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    /** Алгоритм сортировки выбором */
    private static void selectionSort(int[] array){
        for (int left = 0; left < array.length - 1; left++) {
            int minInt = left;
            for (int i = left + 1; i < array.length; i++) {
                if (array[i] < array[minInt]) {
                    minInt = i;
                }
            }
            // меняем элементы массива местами
            swap(array, minInt, left);
        }
    }
}
