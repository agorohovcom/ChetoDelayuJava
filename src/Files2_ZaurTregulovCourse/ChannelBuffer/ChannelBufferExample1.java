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


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
