package Files2_ZaurTregulovCourse.ChannelBuffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample2 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile(".\\src\\Files2_ZaurTregulovCourse\\ChannelBuffer\\text2.txt", "r");
            // содержимое файла: abcdefghij
            FileChannel channel = file.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());    // a
            System.out.println((char) buffer.get());    // b
            System.out.println((char) buffer.get());    // c

            // rewind() перемещает позицию на ячейку 0
            buffer.rewind();

            System.out.println((char) buffer.get());    // a

            System.out.println("---------------------------");

            buffer.compact();
            channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }

            System.out.println("---------------------------");

            buffer.clear();
            channel.read(buffer);
            buffer.flip();
            System.out.println((char) buffer.get());    // g

            // ставим отметку
            buffer.mark();
            System.out.println((char) buffer.get());    // h
            System.out.println((char) buffer.get());    // i

            // возвращаемся на позицию с отметкой
            buffer.reset();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
