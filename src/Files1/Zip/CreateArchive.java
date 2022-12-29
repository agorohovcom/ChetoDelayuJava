package Files1.Zip;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateArchive {
    public static void main(String[] args) throws IOException {
        Path dir;
        // Если папки нет, создаём
        if(!Files.exists(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks"))){
            dir = Files.createDirectory(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks"));
            System.out.println("Папка dirForJRTasks создана.");
        } else {
            dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks");
            System.out.println("Папка dirForJRTasks уже есть.");
        }
        // -------------------------------------------------------------
        // создаем архив
        FileOutputStream zipFile = new FileOutputStream("C:/Users/Sanchio/Desktop/dirForJRTasks/archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);
        // кладем в него ZipEntry – «архивный объект»
        zip.putNextEntry(new ZipEntry("document.txt"));
        // создаём другой текстовый файл и что-то пишем в него
        Path file = Files.createFile(Paths.get("C:/Users/Sanchio/Desktop/dirForJRTasks/document-for-archive.txt"));
        FileWriter fileWriter = new FileWriter(file.toString());
        fileWriter.write("Лол, это я пишу в файл");
        fileWriter.close();
        // копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        Files.copy(file, zip);
        zip.close();
    }



}
