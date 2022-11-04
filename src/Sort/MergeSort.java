package Sort;

import java.util.Date;

public class MergeSort extends SortUtility{
    private final static String NAME = "СОРТИРОВКА СЛИЯНИЕМ";

    public static void doSort(int[] unsortedArray) {
        // проверяем, совпадает ли переданный массив с начальным
        unsortedArrayCheck(unsortedArray);
        // клонируем массив, чтобы не "задеть" оригинал
        int[] array = unsortedArray.clone();
        // засекаем время выполнения метода
        Date start = new Date();
        // вызываем рекурсивный метод сортировки слиянием
        mergeSort(array, 0, array.length - 1);
        // проверяем результат и выводим в консоль
        checkAndResultToConsole(array, NAME, start);
    }

    /** АЛГОРИТМ СОРТИРОВКИ СЛИЯНИЕМ 1/2 */
    private static void mergeSort(int[] array, int left, int right){
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /** АЛГОРИТМ СОРТИРОВКИ СЛИЯНИЕМ 2/2 */
    private static void merge(int[] array, int left, int mid, int right){
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаём временные подмассивы
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        // копируем их leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++){
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight){
                if(leftArray[leftIndex] < rightArray[rightIndex]){
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft){
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight){
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
