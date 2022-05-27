package Files.FromManyFilesToOne;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

class WithByteReadAndWrite {
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
        // ----------------------------------------------------------------------
        // список потоков ввода из кусочков файла
        ArrayList<FileInputStream> streams = new ArrayList<>();
        for(int i = 0; i < paths.size(); i++){
            streams.add(new FileInputStream(paths.get(i).toString()));
        }

        FileOutputStream fos = new FileOutputStream(resultFile.toString());
        for(InputStream is : streams){
            while (is.available() > 0){
                fos.write(is.read());
            }
            is.close();
        }
    }
}
