package Sort;

import java.util.*;

public class SortSomeIntegersAlgorithms {

    public static void main(String[] args) {
        // наполняем массив рандомными значениями от 0 до 9999
        int[] unsortedArray = new int[10000];   // 10000
        Random random = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(10000);   //10000
        }
        // выводить содержимое массивов в консоль?
        showContent = false;

        System.out.printf("Создан массив int со значениями 0 - 9999 на %d чисел", unsortedArray.length);
        if (showContent) {
            System.out.println();
            for (int i : unsortedArray) System.out.print(i + " ");
            System.out.println("\n");
        } else System.out.println("\n");

        bubbleSortWithTwoFor(unsortedArray);
        bubbleSortWithWhileAndFor(unsortedArray);
        selectionSort(unsortedArray);
        insertionSort(unsortedArray);
        shellSort(unsortedArray);
        shuttleSort(unsortedArray);
        quickSort(unsortedArray);

        if (showContent) {
            System.out.println("------------------------------------------------------------\n" +
                    "Проверяем, что изначальный неотсортированый массив нетронут:");
            for (int i : unsortedArray) System.out.print(i + " ");
            System.out.println();
        }
    }

    // флаг для вывода содержимого массивов в консоль
    static boolean showContent = false;

    // считаем время выполнения алгоритма и выводим результат в консоль
    private static void resultToConsole(int[] array, String name, Date start) {
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
            System.out.printf("%s: " + time + " миллисек", name);
            if (showContent) {
                System.out.println();
                for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
                System.out.println();
            } else System.out.println();
        } else
            System.out.printf("ОШИБКА! %s: некорректный результат", name);
    }

    public static void bubbleSortWithTwoFor(int[] unsortedArray) {
        String name = "СОРТИРОВКА ПУЗЫРЬКОМ (2 цикла for)";
        // клонируем массив, чтобы не трогать оригинал
        int[] array = unsortedArray.clone();
        // засекаем начало сортировки
        Date start = new Date();
        // алгоритм сотрировки "пузырьком"
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    public static void bubbleSortWithWhileAndFor(int[] unsortedArray) {
        String name = "СОРТИРОВКА ПУЗЫРЬКОМ (while и for)";
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
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                    isNotSorted = true;
                }
            }
        }
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    public static void selectionSort(int[] unsortedArray) {
        String name = "СОРТИРОВКА ВЫБОРОМ";
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "выбором"
        for (int left = 0; left < array.length - 1; left++) {
            int minInt = left;
            for (int i = left + 1; i < array.length; i++) {
                if (array[i] < array[minInt]) {
                    minInt = i;
                }
            }
            int tmp = array[minInt];
            array[minInt] = array[left];
            array[left] = tmp;
        }
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    public static void insertionSort(int[] unsortedArray) {
        String name = "СОРТИРОВКА ВСТАВКАМИ";
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "вставками"
        int j;
        for (int i = 1; i < array.length; i++) {
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    public static void shellSort(int[] unsortedArray) {
        String name = "СОРТИРОВКА ШЕЛЛА";
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
                        int temp = array[i + gap];
                        array[i + gap] = array[i];
                        array[i] = temp;
                    }
                }
            }
            // пересчитываем промежуток
//            gap = gap / 2; // простой вариант
            // метод Кнута
            gap = (gap - 1) / 3;
        }
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    public static void shuttleSort(int[] unsortedArray) {
        String name = "ЧЕЛНОЧНАЯ СОРТИРОВКА";
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм "челночной" сортировки
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (array[j] < array[j - 1]) {
                        int temp2 = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp2;
                    } else break;
                }
            }
        }
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    //БЫСТРАЯ СОРТИРОВКА (в этом методе вызывается рекурсивный метод quickSortWithRecursion())
    public static void quickSort(int[] unsortedArray) {
        String name = "БЫСТРАЯ СОРТИРОВКА";
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем рекурсивный метод быстрой сортировки
        quickSortWithRecursion(array, 0, array.length - 1);
        // выводим результат в консоль
        resultToConsole(array, name, start);
    }

    private static void quickSortWithRecursion(int[] array, int low, int high) {
        // алгоритм "быстрой" сортировки
        if (array.length == 0 || low >= high) return;
        // выбрать опорный элемент (по сути, можно выбрать какой угодно
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
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSortWithRecursion(array, low, j);

        if (high > i)
            quickSortWithRecursion(array, i, high);
    }
}
