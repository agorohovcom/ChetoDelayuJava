package Collections.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * В основе HashMap лежи массив, элементами которого являются структуры LinkedList.
 * При оздании HashMap мы можем задать 2 параметра, влияющие на производительность:
 * - Initial capacity - начальный размер массива,
 * - Load factor - коэффициент заполненноти массива, после которой происходит его
 * увеличение вдвое.
 *
 * В качестве ключа важно испоьзовать immutable объекты
 */
public class HashMapExample3 {
    public static void main(String[] args) {
        // чем больше initialCapacity и loadFactor, тем больше HashMap занимает памяти,
        // но быстрее поиск по нему
        Map<Integer, String> map = new HashMap<>(16, 0.75f);
    }
}
