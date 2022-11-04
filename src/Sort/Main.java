package Sort;

public class Main extends SortUtility {

    public static void main(String[] args) {
        // задаём массив для сортировок
        // параметры: размер массива, диапазон значений, выводить ли содержимое в консоль
        int [] unsortedArray = createArrayForSort(10000, 10000, false);

        // вызов сортировок
        BubbleSortWithTwoFor.doSort(unsortedArray);         // СОРТИРОВКА ПУЗЫРЬКОМ (2 цикла for)
        BubbleSortWithWhileAndFor.doSort(unsortedArray);    // СОРТИРОВКА ПУЗЫРЬКОМ (while и for)
        SelectionSort.doSort(unsortedArray);                // СОРТИРОВКА ВЫБОРОМ
        InsertionSort.doSort(unsortedArray);                // СОРТИРОВКА ВСТАВКАМИ
        ShellSort.doSort(unsortedArray);                    // СОРТИРОВКА ШЕЛЛА
        ShuttleSort.doSort(unsortedArray);                  // ЧЕЛНОЧНАЯ СОРТИРОВКА
        QuickSort.doSort(unsortedArray);                    // БЫСТРАЯ СОРТИРОВКА
        MergeSort.doSort(unsortedArray);                    // СОРТИРОВКА СЛИЯНИЕМ
        DefaultArraysSort.doSort(unsortedArray);            // СТАНДАРТНАЯ СОРТИРОВКА (Arrays.sort())
    }
}
