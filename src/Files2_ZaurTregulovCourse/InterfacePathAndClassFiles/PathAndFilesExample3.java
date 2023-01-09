package Files2_ZaurTregulovCourse.InterfacePathAndClassFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesExample3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\testPathAndFiles2.txt");
        if(!Files.exists(filePath)) Files.createFile(filePath);

        String dialog = "-Privet\n-Privet\n-Kak dela?\n-Horosho! A u tebya?\n-Tozhe horosho!";

        // Files.write()
        Files.write(filePath, dialog.getBytes(StandardCharsets.UTF_8));

        // Files.readAllLines()
        List<String> list = Files.readAllLines(filePath);
        for(String s : list){
            System.out.println(s);
        }
    }
}
