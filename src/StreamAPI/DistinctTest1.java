package StreamAPI;

import java.util.stream.Stream;

public class DistinctTest1 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);

        // distinct()
        stream.distinct().forEach(System.out::println);
    }
}
