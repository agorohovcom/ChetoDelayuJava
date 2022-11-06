package Sort;

import java.util.Date;

public class HeapSort extends SortUtility {
    private final static String NAME = "ПИРАМИДАЛЬНАЯ СОРТИРОВКА";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем стандартную сортировку
        heapSort(array);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    /**
     * АЛГОРИТМ ПИРАМИДАЛЬНОЙ СОРТИРОВКИ
     */
    // процедура преобразования в кучу
    private static void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // если левый дочерний больше родительского
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        // если правый дочерний больше родительского
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, length, largest);
        }
    }

    private static void heapSort(int[] array) {
        int length = array.length;
        // построение кучи (перегруппируем массив)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // один за другим извлекаем элементы из кучи
        for (int i = length - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            swap(array, 0, i);

            // вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
}
