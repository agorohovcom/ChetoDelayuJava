package Files1.DownloadFiles;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

class Main {
    public static void main(String[] args) throws IOException {
        URL ulr = new URL("https://images.wallpaperscraft.ru/image/single/ulitsa_osveshchenie_podsvetka_134856_1920x1080.jpg");
        // Сохраняем имя конечного файла из ссылки в переменную nameFromURL
        String nameFromURL = new String(ulr.toString().split("/")[ulr.toString().split("/").length-1]);
        InputStream inputStream = ulr.openStream();

        Path dir;
        // Если папки нет, создаём
        if(!Files.exists(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks"))){
            dir = Files.createDirectory(Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks"));
            System.out.println("Папка dirForJRTasks создана.");
        } else {
            dir = Path.of("C:/Users/Sanchio/Desktop/dirForJRTasks");
            System.out.println("Папка dirForJRTasks уже есть.");
        }
        // Финальный файл с именем скачиваемого файла
        Path finFile = dir.resolve(nameFromURL);
        // Временный файл для скачивания в этой же папке
        Path tempFile = Files.createTempFile(dir, null, null);
        // Копируем файл из ссылки во временный файл, чтобы при сбое не осталось неполных файлов
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        // Перемещаем файл из временного в конечный, если конечный уже есть -
        // заменяем, временный файл удаляется
        Files.move(tempFile, finFile, StandardCopyOption.REPLACE_EXISTING);
        // Сообщение об успешном скачивании
        System.out.println("Скачивание файла завершено успешно.");
    }
}