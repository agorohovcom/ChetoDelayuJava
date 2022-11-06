package Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

class SortUtility {
    // флаг для вывода содержимого массивов в консоль
    private static boolean showContent = false;

    // сюда сохраним созданный массив после инициализации в createArrayForSort()
    private static int[] unsortedArrayClone;

    // проверяем, не перезаписали ли мы начальный массив другой сортировкой
    // запускается перед каждой сортировкой в методе sort()
    protected static void unsortedArrayCheck(int[] array) {
        if (!Arrays.equals(array, unsortedArrayClone)) {
            throw new Error("ОШИБКА! Начальный массив изменён. Нужно сортировать клон массива, а не сам массив.");
        }
    }

    // создание массива для сортировок
    // параметры: размер массива, диапазон значений, создать ли отсортированный массив и выводить ли содержимое в консоль
    protected static int[] createArrayForSort(int arrayCapacity, int valuesMaxSize, boolean createSortedArray, boolean showContent) {
        // флаг, выводить ли в консоль содержимое массивов
        SortUtility.showContent = showContent;
        // наполняем массив рандомными значениями в заданных пределах
        int[] newArray = new int[arrayCapacity];
        // если createSortedArray == true - создаем отсортированный массив, если false - случайный
        if (createSortedArray) {
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = i;
            }
            System.out.printf("Создан отсортированный массив int[] от 0 до %d", arrayCapacity - 1);
        } else {
            Random random = new Random();
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = random.nextInt(valuesMaxSize);
            }
            System.out.printf("Создан случайный массив int[] на %d элементов, диапазон значений от 0 до %d", arrayCapacity, valuesMaxSize - 1);
        }
        // если showContent = true, выводим содержимое newArray в консоль
        if (showContent) {
            System.out.println();
            for (int i : newArray) System.out.print(i + " ");
            System.out.println("\n");
        } else System.out.println("\n");
        // клонируем созданный массив для проверки unsortedArrayCheck перед каждой сортировкой
        unsortedArrayClone = newArray.clone();
        return newArray;
    }

    // меняем элементы массива местами
    protected static void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    // считаем время выполнения алгоритма,
    // проверяем корректность работы сортировки
    // и выводим результат в консоль
    protected static void checkAndResultToConsole(int[] array, String name, Date start) {
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // проверяем, корректно ли отсортирован массив
        boolean isCorrectSorted = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                isCorrectSorted = false;
                break;
            }
        }
        // выводим результат в консоль
        if (isCorrectSorted) {
            System.out.printf("%-40s%10d%10s%n", name + ":", time, "миллисек");
            if (showContent) {
                for (int j : array) System.out.print(j + " ");
                System.out.println();
            }
        } else {
            System.out.printf("ОШИБКА! %s: некорректный результат сортировки%n", name);
            if (showContent) {
                for (int j : array) System.out.print(j + " ");
                System.out.println();
            }
        }
    }
}
