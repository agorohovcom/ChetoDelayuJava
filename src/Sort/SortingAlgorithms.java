package Sort;

import java.util.*;

public class SortingAlgorithms {

    // СОРТИРОВКА ПУЗЫРЬКОМ (2 цикла for)
    public static void bubbleSortWithTwoFor(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
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
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"ПУЗЫРЬКОМ\" (2 цикла for) - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
    }

    // СОРТИРОВКА ПУЗЫРЬКОМ (while и for)
    public static void bubbleSortWithWhileAndFor(int[] unsortedArray) {
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
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"ПУЗЫРЬКОМ\" (while и for) - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
    }

    // СОРТИРОВКА ВЫБОРОМ
    public static void selectionSort(int[] unsortedArray) {
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
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"ВЫБОРОМ\" - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
    }

    // СОРТИРОВКА ВСТАВКАМИ
    public static void insertionSort(int[] unsortedArray) {
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
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"ВСТАВКАМИ\" - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
    }

    // СОРТИРОВКА ШЕЛЛА
    public static void shellSort(int[] unsortedArray) {
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
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"ШЕЛЛА\" - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
    }

    // ЧЕЛНОЧНАЯ СОРТИРОВКА
    public static void shuttleSort(int[] unsortedArray) {
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
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"ЧЕЛНОЧНОЙ\" - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
    }

    // БЫСТРАЯ СОРТИРОВКА (в этом методе вызывается рекурсивный метод quickSortWithRecursion())
    public static void quickSort(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем рекурсивный метод быстрой сортировки
        quickSortWithRecursion(array, 0, array.length - 1);
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.print("Результат сортировки \"БЫСТРОЙ\" - " + time + " миллисек");
        if(showContent) {
            System.out.print(":\n");
            for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
            System.out.println();
        }
        else System.out.print(".\n");
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

    // флаг для вывода содержимого массивов в консоль
    static boolean showContent = false;

    public static void main(String[] args) {
        // наполняем массив рандомными значениями от 0 до 9999
        int[] unsortedArray = new int[10000];
        Random random = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(10000);
        }
        // выводить содержимое массивов в консоль?
        showContent = false;

        System.out.print("Создан массив int (0 - 9999) на " + unsortedArray.length + " чисел для сортировок");
        if (showContent){
            System.out.print(":\n");
            for (int i : unsortedArray) System.out.print(i + " ");
            System.out.println("\n");
        }
        else System.out.print(".\n\n");

        bubbleSortWithTwoFor(unsortedArray);
        bubbleSortWithWhileAndFor(unsortedArray);
        selectionSort(unsortedArray);
        insertionSort(unsortedArray);
        shellSort(unsortedArray);
        shuttleSort(unsortedArray);
        quickSort(unsortedArray);

        if(showContent) {
            System.out.println("------------------------------------------------------------\n" +
                    "Проверяем, что изначальный неотсортированый массив нетронут:");
            for (int i : unsortedArray) System.out.print(i + " ");
            System.out.println();
        }
    }
}
