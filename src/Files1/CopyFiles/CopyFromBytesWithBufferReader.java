package Files1.CopyFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFromBytesWithBufferReader {
    public static void main(String[] args) throws IOException {
        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/3");
        if (Files.notExists(dir)) Files.createDirectories(dir.toAbsolutePath());
        // первый файл
        Path file1 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/3/file1.txt");
        if (Files.notExists(file1)) Files.createFile(file1.toAbsolutePath());
        // второй файл
        Path file2 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/3/file2.txt");
        if (Files.notExists(file2)) Files.createFile(file2.toAbsolutePath());
        // --------------------------------------------------------------------------

        BufferedReader br = new BufferedReader(new FileReader(file1.toString()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2.toString()));

        int c;
        while((c = br.read()) != -1){
            bw.write((char) c);
        }
        // если не закрыть, кусок данных не запишется
        br.close();
        bw.close();

        System.out.println("Размер первого файла " + Files.size(file1));
        System.out.println("Размер второго файла " + Files.size(file2));


    }
}
