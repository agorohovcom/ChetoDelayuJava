package Files2_ZaurTregulovCourse.ChannelBuffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample1 {
    public static void main(String[] args) {
        try(RandomAccessFile file =
                    new RandomAccessFile(".\\src\\Files2_ZaurTregulovCourse\\ChannelBuffer\\text1.txt", "rw");
            // ЧТЕНИЕ ИЗ ФАЙЛА

            // создаём канал прямо из файла
            FileChannel channel = file.getChannel()){

            // создаём буфер на 25 байт
            ByteBuffer buffer = ByteBuffer.allocate(25);

            // сбда будем записывать стих из файла
            StringBuilder stix = new StringBuilder();

            // читаем в буфер. этот метод возвращает кол-во прочитанных байт
            int byteRead = channel.read(buffer);

            // пока есть что читать
            while (byteRead > 0){
                System.out.println("Прочитано байт: " + byteRead);

                // переводим буффер в режим чтения
                buffer.flip();

                // пока есть что читать из буффера,
                // читаем информацию по 1 байту за раз
                while (buffer.hasRemaining()){
                    stix.append((char) buffer.get());
                }

                // переводим буффер в режим записи
                buffer.clear();

                // сохраняем в переменную byteRead следующий байт
                byteRead = channel.read(buffer);
            }

            System.out.println(stix);

            // =========================

            String text = "\nOriginal HP 67XL Black High-yield Ink Cartridge | Works with HP DeskJet 1255, 2700, 4100 Series, HP ENVY 6000, 6400 Series | Eligible for Instant Ink | 3YM57AN";
//            // ЗАПИСЬ В ФАЙЛ СПОСОБ 1
//
//            // создадим новый буффер размером как строка text, а канал оставим тот же
//            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length);
//
//            // добавим строку в буффер
//            buffer2.put(text.getBytes());
//
//            // переводим буффер в режим чтения
//            buffer2.flip();
//
//            // записываем строку text в файл из буффера
//            channel.write(buffer2);

//            // ЗАПИСЬ В ФАЙЛ СПОСОБ 2

            // используем метод wrap(), он записывает информацию из текста в буффер
            // нам не нужно:
            // вручную указывать размер буффера, записывать в буфер и делать флип
            // эти 3 вещи делает метод wrap()
            ByteBuffer buffer2 = ByteBuffer.wrap(text.getBytes());

            // записываем строку text в файл из буффера
            channel.write(buffer2);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
