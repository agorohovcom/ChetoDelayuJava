package Multitreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsFight {
    public static void main(String[] args) {
        SuperThreadGame game = new SuperThreadGame(10);

        Thread thread1 = new Thread(() -> {
            while (game.startValue >= 1) {
                game.decrement();
            }
            System.out.println("Декремент закончил игру");
        });

        Thread thread2 = new Thread(() -> {
            while (game.startValue < game.finish) {
                game.increment();
            }
            System.out.println("Инкремент закончил игру");
        });
        thread1.start();
        thread2.start();
    }
}

class SuperThreadGame {
    Lock lock = new ReentrantLock();
    int startValue;
    int finish;

    public SuperThreadGame(int startValue) {
        this.startValue = startValue;
        this.finish = startValue * 2;
        System.out.println("Игра началась! Отсчёт идет от " + startValue + "\n");
    }

    void decrement() {
        lock.lock();
        startValue--;
        System.out.println("Декремент отнял 1, значение = " + startValue);
        lock.unlock();
    }

    void increment() {
        lock.lock();
        startValue++;
        System.out.println("Инкремент прибавил 1, значение = " + startValue);
        lock.unlock();
    }
}

// Пример вывода:

//    Игра началась! Отсчёт идет от 10

//        Декремент отнял 1, значение = 9
//        Инкремент прибавил 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Декремент отнял 1, значение = 9
//        Инкремент прибавил 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Декремент отнял 1, значение = 9
//        Инкремент прибавил 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Декремент отнял 1, значение = 9
//        Инкремент прибавил 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Инкремент прибавил 1, значение = 19
//        Декремент отнял 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Инкремент прибавил 1, значение = 19
//        Декремент отнял 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Инкремент прибавил 1, значение = 11
//        Инкремент прибавил 1, значение = 12
//        Инкремент прибавил 1, значение = 13
//        Инкремент прибавил 1, значение = 14
//        Инкремент прибавил 1, значение = 15
//        Инкремент прибавил 1, значение = 16
//        Инкремент прибавил 1, значение = 17
//        Инкремент прибавил 1, значение = 18
//        Инкремент прибавил 1, значение = 19
//        Декремент отнял 1, значение = 18
//        Инкремент прибавил 1, значение = 19
//        Инкремент прибавил 1, значение = 20
//        Инкремент закончил игру
//        Декремент отнял 1, значение = 19
//        Декремент отнял 1, значение = 18
//        Декремент отнял 1, значение = 17
//        Декремент отнял 1, значение = 16
//        Декремент отнял 1, значение = 15
//        Декремент отнял 1, значение = 14
//        Декремент отнял 1, значение = 13
//        Декремент отнял 1, значение = 12
//        Декремент отнял 1, значение = 11
//        Декремент отнял 1, значение = 10
//        Декремент отнял 1, значение = 9
//        Декремент отнял 1, значение = 8
//        Декремент отнял 1, значение = 7
//        Декремент отнял 1, значение = 6
//        Декремент отнял 1, значение = 5
//        Декремент отнял 1, значение = 4
//        Декремент отнял 1, значение = 3
//        Декремент отнял 1, значение = 2
//        Декремент отнял 1, значение = 1
//        Декремент отнял 1, значение = 0
//        Декремент закончил игру
//
//        Process finished with exit code 0