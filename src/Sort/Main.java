package Sort;

public class Main extends SortUtility {

    public static void main(String[] args) {
        // задаём массив для сортировок
        // параметры: размер массива и диапазон значений, создать ли отсортированный массив, выводить ли содержимое в консоль
        int [] unsortedArray = createArrayForSort(100000, 100000, false, false);

        // вызов сортировок
        BubbleSortWithTwoFor.doSort(unsortedArray);         // СОРТИРОВКА ПУЗЫРЬКОМ (2 цикла for)
        BubbleSortWithWhileAndFor.doSort(unsortedArray);    // СОРТИРОВКА ПУЗЫРЬКОМ (while и for)
        SelectionSort.doSort(unsortedArray);                // СОРТИРОВКА ВЫБОРОМ
        InsertionSort.doSort(unsortedArray);                // СОРТИРОВКА ВСТАВКАМИ
        ShellSort.doSort(unsortedArray);                    // СОРТИРОВКА ШЕЛЛА
        ShuttleSort.doSort(unsortedArray);                  // ЧЕЛНОЧНАЯ СОРТИРОВКА
        QuickSort.doSort(unsortedArray);                    // БЫСТРАЯ СОРТИРОВКА
        MergeSort.doSort(unsortedArray);                    // СОРТИРОВКА СЛИЯНИЕМ
        HeapSort.doSort(unsortedArray);                     // ПИРАМИДАЛЬНАЯ СОРТИРОВКА
        DefaultArraysSort.doSort(unsortedArray);            // СТАНДАРТНАЯ СОРТИРОВКА (Arrays.sort())
    }
}
