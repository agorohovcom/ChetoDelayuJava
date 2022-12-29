package Files1.CopyFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFilesFromByteArray {
    public static void main(String[] args) throws IOException {
        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/4");
        if (Files.notExists(dir)) Files.createDirectories(dir.toAbsolutePath());
        // первый файл
        Path file1 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/4/file1.txt");
        if (Files.notExists(file1)) Files.createFile(file1.toAbsolutePath());
        // второй файл
        Path file2 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/4/file2.txt");
        if (Files.notExists(file2)) Files.createFile(file2.toAbsolutePath());
        // --------------------------------------------------------------------------
        FileInputStream fis = new FileInputStream(file1.toString());
        FileOutputStream fos = new FileOutputStream(file2.toString());
        // Чем больше буфер, тем быстрее копируется
        byte [] buffer = new byte[1000];

        long startTime = System.currentTimeMillis();

        while (fis.available() > 0){
            int count = fis.read(buffer);
            fos.write(buffer, 0, count);
        }
        fis.close();
        fos.close();

        System.out.println("Время копирования: " + (System.currentTimeMillis()-startTime));

        System.out.println("Размер первого файла " + Files.size(file1));
        System.out.println("Размер второго файла " + Files.size(file2));
    }
}
