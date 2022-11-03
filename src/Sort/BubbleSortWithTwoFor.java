package Sort;

import java.util.Date;

class BubbleSortWithTwoFor extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ПУЗЫРЬКОМ (2 цикла for)";

    public static void sort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не трогать оригинал
        int[] array = unsortedArray.clone();
        // засекаем начало сортировки
        Date start = new Date();
        // алгоритм сотрировки "пузырьком"
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j])
                    // меняем элементы массива местами
                    swap(array, j - 1, j);
            }
        }
        // выводим результат в консоль
        checkAndResultToConsole(array, NAME, start);
    }
}
