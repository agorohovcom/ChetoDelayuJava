package Files1.FromManyFilesToOne;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class WithBufferedReader {
    public static void main(String[] args) throws IOException {

        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1");
        if (Files.notExists(dir)) dir = Files.createDirectories(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1"));
        // создаём финальный файл
        Path resultFile = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/result.txt");
//        if(Files.notExists(resultFile)) resultFile = Files.createFile(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/result.txt"));
        // список частей файла
        ArrayList<Path> paths = new ArrayList<>();
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/1.txt"));
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/2.txt"));
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/3.txt"));
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/4.txt"));
        // ----------------------------------------------------------------------
        // список потоков ввода из кусочков файла
        ArrayList<BufferedReader> streams = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            streams.add(new BufferedReader(new FileReader(paths.get(i).toString())));
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile.toString()));
        for (BufferedReader br : streams) {
            int c;
            while((c = br.read()) != -1){
                bw.write(c);
            }
            br.close();
        }
        bw.close();
    }
}

