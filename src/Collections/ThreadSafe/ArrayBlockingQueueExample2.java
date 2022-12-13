package Collections.ThreadSafe;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * При добавлении и удалении разными потоками
 * используются методы put() и take()
 */
public class ArrayBlockingQueueExample2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

        // Producer
        new Thread(() -> {
          int i = 0;
          while (true){
              try {
                  arrayBlockingQueue.put(++i);
                  System.out.println("Producer dobavil: " + i +
                          " " + arrayBlockingQueue);
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        }).start();

        // Consumer
        new Thread(() -> {
            while (true){
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer zabral: " + j +
                            " " + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}

// Output:

//        Producer dobavil: 1 []
//        Consumer zabral: 1 []
//        Producer dobavil: 2 [2]
//        Producer dobavil: 3 [2, 3]
//        Consumer zabral: 2 [3]
//        Producer dobavil: 4 [3, 4]
//        Producer dobavil: 5 [3, 4, 5]
//        Producer dobavil: 6 [3, 4, 5, 6]
//        Consumer zabral: 3 [4, 5, 6]
//        Producer dobavil: 7 [4, 5, 6, 7]
//        Consumer zabral: 4 [5, 6, 7]
//        Producer dobavil: 8 [5, 6, 7, 8]
//        Producer dobavil: 9 [6, 7, 8, 9]
//        Consumer zabral: 5 [6, 7, 8, 9]
//        Consumer zabral: 6 [7, 8, 9]
//        Producer dobavil: 10 [7, 8, 9, 10]
//        Consumer zabral: 7 [8, 9, 10, 11]
//        Producer dobavil: 11 [8, 9, 10, 11]
//        Producer dobavil: 12 [9, 10, 11, 12]
//        Consumer zabral: 8 [9, 10, 11, 12]
//        Consumer zabral: 9 [10, 11, 12]
//        Producer dobavil: 13 [10, 11, 12, 13]
//        Producer dobavil: 14 [11, 12, 13, 14]
//        Consumer zabral: 10 [11, 12, 13, 14]
//        Consumer zabral: 11 [12, 13, 14, 15]
//        Producer dobavil: 15 [12, 13, 14, 15]
//
//        Process finished with exit code 130
