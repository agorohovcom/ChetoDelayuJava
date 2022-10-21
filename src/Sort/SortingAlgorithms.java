package Sort;

import java.util.*;

public class SortingAlgorithms {

    // СОРТИРОВКА ПУЗЫРЬКОМ (2 цикла for)
    public static void bubbleSortWithTwoFor(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] tempArray = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "пузырьком"
        for (int i = 0; i < tempArray.length - 1; i++) {
            for (int j = tempArray.length - 1; j > i; j--) {
                if (tempArray[j - 1] > tempArray[j]) {
                    int tmp = tempArray[j - 1];
                    tempArray[j - 1] = tempArray[j];
                    tempArray[j] = tmp;
                }
            }
        }
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.println("Результат сортировки \"ПУЗЫРЬКОМ\" (2 цикла for) за " + time + " миллисек:");
        for (int i = 0; i < tempArray.length; i++) System.out.print(tempArray[i] + " ");
        System.out.println();
    }

    // СОРТИРОВКА ПУЗЫРЬКОМ (while и for)
    public static void bubbleSortWithWhileAndFor(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] tempArray = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "пузырьком" (while и for)
        boolean isNotSorted = true;
        while (isNotSorted) {
            isNotSorted = false;
            for (int i = 1; i < tempArray.length; i++) {
                if (tempArray[i] < tempArray[i - 1]) {
                    int tmp = tempArray[i - 1];
                    tempArray[i - 1] = tempArray[i];
                    tempArray[i] = tmp;
                    isNotSorted = true;
                }
            }
        }
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.println("Результат сортировки \"ПУЗЫРЬКОМ\" (while и for) за " + time + " миллисек:");
        for (int i = 0; i < tempArray.length; i++) System.out.print(tempArray[i] + " ");
        System.out.println();
    }

    // СОРТИРОВКА ВЫБОРОМ
    public static void selectionSort(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] tempArray = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "выбором"
        for (int left = 0; left < tempArray.length - 1; left++) {
            int minInt = left;
            for (int i = left + 1; i < tempArray.length; i++) {
                if (tempArray[i] < tempArray[minInt]) {
                    minInt = i;
                }
            }
            int tmp = tempArray[minInt];
            tempArray[minInt] = tempArray[left];
            tempArray[left] = tmp;
        }
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.println("Результат сортировки \"ВЫБОРОМ\" за " + time + " миллисек:");
        for (int i = 0; i < tempArray.length; i++) System.out.print(tempArray[i] + " ");
        System.out.println();
    }

    // СОРТИРОВКА ВСТАВКАМИ
    public static void insertionSort(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] tempArray = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм сотрировки "вставками"
        int j;
        for (int i = 1; i < tempArray.length; i++) {
            int swap = tempArray[i];
            for (j = i; j > 0 && swap < tempArray[j - 1]; j--) {
                tempArray[j] = tempArray[j - 1];
            }
            tempArray[j] = swap;
        }
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.println("Результат сортировки \"ВСТАВКАМИ\" за " + time + " миллисек:");
        for (int i = 0; i < tempArray.length; i++) System.out.print(tempArray[i] + " ");
        System.out.println();
    }

    // СОРТИРОВКА ШЕЛЛА
    public static void shellSort(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] tempArray = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм "челночной" сортировки
        // сперва высчитываем промежуток между проверяемыми элементами, выриантов есть много
//        int gap = 2; - // простой вариант
        // метод Кнута
        int gap = 1;
        while (gap <= tempArray.length / 3){
            gap = gap * 3 + 1;
        }
        while(gap > 0){
            for(int right = 0; right < tempArray.length; right++){
                for(int i = right - gap; i >= 0; i -= gap){
                    if(tempArray[i] > tempArray[i + gap]){
                        int temp = tempArray[i + gap];
                        tempArray[i + gap] = tempArray[i];
                        tempArray[i] = temp;
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
        System.out.println("Результат сортировки \"ШЕЛЛА\" за " + time + " миллисек:");
        for (int i = 0; i < tempArray.length; i++) System.out.print(tempArray[i] + " ");
        System.out.println();
    }

    // ЧЕЛНОЧНАЯ СОРТИРОВКА
    public static void shuttleSort(int[] unsortedArray) {
        // клонируем массив, чтобы не "задеть" оригинал
        int[] tempArray = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // алгоритм "челночной" сортировки
        for(int i = 1; i < tempArray.length; i++){
            if(tempArray[i] < tempArray[i - 1]){
                int temp = tempArray[i - 1];
                tempArray[i - 1] = tempArray[i];
                tempArray[i] = temp;
                for(int j = i - 1; (j - 1) >= 0; j--){
                    if(tempArray[j] < tempArray[j - 1]){
                        int temp2 = tempArray[j - 1];
                        tempArray[j - 1] = tempArray[j];
                        tempArray[j] = temp2;
                    } else break;
                }
            }
        }
        // расчитываем время выполнения метода
        long time = new Date().getTime() - start.getTime();
        // выводим результат в консоль
        System.out.println("Результат \"ЧЕЛНОЧНОЙ\" сортировки за " + time + " миллисек:");
        for (int i = 0; i < tempArray.length; i++) System.out.print(tempArray[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // наполняем массив рандомными значениями от 0 до 9999
        int[] unsortedArray = new int[10000];
        Random random = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(10000);
        }

        System.out.println("Массив int на " + unsortedArray.length + " чисел для сортировок:");
        for (int i : unsortedArray) System.out.print(i + " ");
        System.out.println("\n-----------------------------------------");

        bubbleSortWithTwoFor(unsortedArray);
        bubbleSortWithWhileAndFor(unsortedArray);
        selectionSort(unsortedArray);
        insertionSort(unsortedArray);
        shellSort(unsortedArray);
        shuttleSort(unsortedArray);

        System.out.println("------------------------------------------------------------\n" +
                "Проверяем, что изначальный неотсортированый массив нетронут:");
        for (int i : unsortedArray) System.out.print(i + " ");
        System.out.println();
    }
}
