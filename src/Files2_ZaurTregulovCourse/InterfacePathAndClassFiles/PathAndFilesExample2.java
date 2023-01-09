package Files2_ZaurTregulovCourse.InterfacePathAndClassFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesExample2 {
    public static void main(String[] args) throws IOException {
        // файл
        Path filePath = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\testPathAndFiles.txt");
        // папка
        Path directoryPath = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\m");
        // ещё папка
        Path directoryBPass = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\B");

        // Files.copy()
        // StandardCopyOption.REPLACE_EXISTING - если уже есть, заменить
//        Files.copy(filePath, directoryPath.resolve(filePath.getFileName()));
        Files.copy(filePath, directoryPath.resolve("testPathAndFiles3NewName.txt"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Done!");

        // копируется папка без содержимого
//        Files.copy(directoryBPass, directoryPath.resolve("BB"));
        Files.copy(directoryBPass, directoryPath.resolve("BB"), StandardCopyOption.REPLACE_EXISTING);

        // Files.move() - перемещение и переименовывание

        // Files.delete() - удаление
        // не удаляет не пустые папки


    }
}
