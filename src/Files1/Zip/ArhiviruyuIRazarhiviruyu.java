package Files1.Zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ArhiviruyuIRazarhiviruyu {
    public static void main(String[] args) throws IOException {
        // создаём папку dir
        Path dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/5");
        if (Files.notExists(dir)) Files.createDirectories(dir.toAbsolutePath());
        // файл для архиавации
        Path file = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/5/107571083_3.jpg");
        if (Files.notExists(file)) Files.createFile(file.toAbsolutePath());

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dir + "/archive.zip"));
        zos.putNextEntry(new ZipEntry("document.jpg"));

        Files.copy(file, zos);
        zos.close();

        Path fileForUnzipping = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks/5/unzipping.jpg");
        if(Files.notExists(fileForUnzipping)) Files.createFile(fileForUnzipping.toAbsolutePath());

        ZipInputStream zis = new ZipInputStream(new FileInputStream("C:/Users/Sanchio/Desktop/dirForJRTasks/5/archive.zip"));

    }
}
