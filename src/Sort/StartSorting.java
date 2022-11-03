package Sort;

import java.util.*;

public class StartSorting extends SortUtility {

    public static void main(String[] args) {
        // задаём массив для сортировок
        // параметры: размер массива, диапазон значений, выводить ли содержимое в консоль
        int [] unsortedArray = createArrayForSort(100000, 10000, false);

        // вызов сортировок
        BubbleSortWithTwoFor.sort(unsortedArray);
        BubbleSortWithWhileAndFor.sort(unsortedArray);
        SelectionSort.sort(unsortedArray);
        InsertionSort.sort(unsortedArray);
        ShellSort.sort(unsortedArray);
        ShuttleSort.sort(unsortedArray);
        QuickSort.sort(unsortedArray);
        DefaultArraysSort.sort(unsortedArray);
    }
}
