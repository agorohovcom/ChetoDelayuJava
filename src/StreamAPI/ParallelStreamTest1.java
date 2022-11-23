package StreamAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Суть Parallel Stream - выполнение заданий в стриме разными
 * ядрами процессора, а затем объединение результатов.
 * 2 способа применить:
 * 1. вместо stream() вызвать parallelStream();
 * 2. в "метод chaining" вызвать метод parallel().
 * Использовать, когда очень много элементов.
 * !!! Нельзя использовать в случаях, когда порядок элементов имеет значение.
 */
public class ParallelStreamTest1 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        // parallelStream()
        double sumResult = list.parallelStream()
                .reduce((accumulator, e) -> accumulator+e)
                .get();
        System.out.println("sumResult: " + sumResult);

        // parallelStream() для деления не подходит
        double divisionResult = list.parallelStream()
                .reduce((accumulator, e) -> accumulator/e)
                .get();
        System.out.println("divisionResult: " + divisionResult);
        // divisionResult: 0.5 (а должно быть 8.0)
    }
}
