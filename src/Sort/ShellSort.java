package Sort;

import java.util.Date;

public class ShellSort extends SortUtility{
    private final static String NAME = "СОРТИРОВКА ШЕЛЛА";

    public static void sort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм "челночной" сортировки
        // сперва высчитываем промежуток между проверяемыми элементами, выриантов есть много
//        int gap = 2; - // простой вариант
        // метод Кнута
        int gap = 1;
        while (gap <= array.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int right = 0; right < array.length; right++) {
                for (int i = right - gap; i >= 0; i -= gap) {
                    if (array[i] > array[i + gap]) {
                        // меняем элементы массива местами
                        swap(array, i, i + gap);
                    }
                }
            }
            // пересчитываем промежуток
//            gap = gap / 2; // простой вариант
            // метод Кнута
            gap = (gap - 1) / 3;
        }
        // выводим результат в консоль
        checkAndResultToConsole(array, NAME, start);
    }
}
