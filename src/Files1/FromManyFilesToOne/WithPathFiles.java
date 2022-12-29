package Files1.FromManyFilesToOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

class WithPathFiles {
    public static void main(String[] args) throws IOException {
        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1");
        if(Files.notExists(dir)) dir = Files.createDirectories(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1"));
        // создаём финальный файл
        Path resultFile = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/result.txt");
//        if(Files.notExists(resultFile)) resultFile = Files.createFile(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/result.txt"));
        // список частей файла
        ArrayList<Path> paths = new ArrayList<>();
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/1.txt"));
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/2.txt"));
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/3.txt"));
        paths.add(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/1/4.txt"));

        for (Path p : paths) {
            List<String> lines = Files.readAllLines(p);
            Files.write(resultFile, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
}