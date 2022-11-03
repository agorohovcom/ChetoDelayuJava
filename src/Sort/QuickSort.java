package Sort;

import java.util.Date;

public class QuickSort extends SortUtility{
    private final static String NAME = "БЫСТРАЯ СОРТИРОВКА";

    // БЫСТРАЯ СОРТИРОВКА (в этом методе вызывается рекурсивный метод quickSort())
    public static void sort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем рекурсивный метод быстрой сортировки
        quickSort(array, 0, array.length - 1);
        // выводим результат в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    private static void quickSort(int[] array, int low, int high) {
        // алгоритм "быстрой" сортировки
        if (array.length == 0 || low >= high) return;
        // выбрать опорный элемент (по сути, можно выбрать какой угодно,
        // но у меня почему-то с крайними элементами не работает)
        int pivot = array[(low + (high - low) / 2)];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                // меняем элементы массива местами
                swap(array, i, j);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
