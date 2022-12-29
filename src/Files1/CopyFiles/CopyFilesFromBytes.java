package Files1.CopyFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFilesFromBytes {
    public static void main(String[] args) throws IOException {
        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/2");
        if (Files.notExists(dir)) Files.createDirectories(dir.toAbsolutePath());
        // первый файл
        Path file1 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/2/file1.txt");
        if (Files.notExists(file1)) Files.createFile(file1.toAbsolutePath());
        // второй файл
        Path file2 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/2/file2.txt");
        if (Files.notExists(file2)) Files.createFile(file2.toAbsolutePath());
        // --------------------------------------------------------------------------
        // потоки побайтового чтения и записи
        FileInputStream fis = new FileInputStream(file1.toString());
        FileOutputStream fos = new FileOutputStream(file2.toString());
        // копируем данные по одному байту
        while (fis.available() > 0){
            fos.write(fis.read());
        }
        // закрываем потоки
        fis.close();
        fos.close();
    }
}
