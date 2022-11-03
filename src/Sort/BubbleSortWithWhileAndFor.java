package Sort;

import java.util.Date;

public class BubbleSortWithWhileAndFor extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ПУЗЫРЬКОМ (while и for)";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем алгоритм сотрировки
        bubbleSortWithWhileAndFor(array);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    /** АЛГОРИТМ СОРТИРОВКИ ПУЗЫРЬКОМ (while и for) */
    private static void bubbleSortWithWhileAndFor(int[] array){
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
    }
}
