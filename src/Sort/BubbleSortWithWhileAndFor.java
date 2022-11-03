package Sort;

import java.util.Date;

public class BubbleSortWithWhileAndFor extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ПУЗЫРЬКОМ (while и for)";

    public static void sort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "пузырьком" (while и for)
        boolean isNotSorted = true;
        while (isNotSorted) {
            isNotSorted = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    // меняем элементы массива местами
                    swap(array, i, i - 1);
                    isNotSorted = true;
                }
            }
        }
        // выводим результат в консоль
        checkAndResultToConsole(array, NAME, start);
    }
}
