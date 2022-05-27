package Files.FromManyFilesToOne;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class WithBufferedReaderUsingMap {
    public static void main(String[] args) throws IOException {

        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1");
        if (Files.notExists(dir)) dir = Files.createDirectories(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1"));
        // создаём финальный файл
        Path resultFile = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/result.txt");
        // создаём карту из частей файла и потоков чтения из них

        Path file1 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/1.txt");
        Path file2 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/2.txt");
        Path file3 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/3.txt");
        Path file4 = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/4.txt");

        Map<Path, BufferedReader> map = new TreeMap<>();
        map.put(file1, new BufferedReader(new FileReader(file1.toString())));
        map.put(file2, new BufferedReader(new FileReader(file2.toString())));
        map.put(file4, new BufferedReader(new FileReader(file4.toString())));
        map.put(file3, new BufferedReader(new FileReader(file3.toString())));

        BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile.toString()));

        for (Map.Entry<Path, BufferedReader> pair : map.entrySet()) {
            int c;
            while ((c = pair.getValue().read()) != -1) {
                bw.write(c);
            }
            pair.getValue().close();
        }
        bw.close();
    }
}
