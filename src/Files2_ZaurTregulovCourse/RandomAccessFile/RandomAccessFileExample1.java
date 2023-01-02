package Files2_ZaurTregulovCourse.RandomAccessFile;

import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample1 {
//    src/Files2_ZaurTregulovCourse/RandomAccessFile/test10.txt
public static void main(String[] args) {
    try(RandomAccessFile file = new RandomAccessFile(".\\src\\Files2_ZaurTregulovCourse\\RandomAccessFile\\test10.txt", "rw")){

        // читаем первый символ
        int a = file.read();
        System.out.println((char) a);
        // читаем оставшуюся строку (поинтер переместился на 1)
        String s1 = file.readLine();
        System.out.println(s1);

        // устанавливаем положение поинтера
        file.seek(101);
        String s2 = file.readLine();
        System.out.println(s2);

        // поиск поинтера
        long position = file.getFilePointer();
        System.out.println(position);

        // возвращаем поинтер в начало файла (на 0 позицию)
//        file.seek(0);
        // символы в файле начиная с положения поинтера будут заменены
//        file.writeBytes("ПРИВЕТ!!!");

        // перемещаем поинтер в конец файла
        file.seek(file.length() - 1);
        // дописываем текст
        file.writeBytes("\n\t\t\t\t\tPen PenApple ApplePen");




    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
