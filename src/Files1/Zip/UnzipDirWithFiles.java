package Files1.Zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipDirWithFiles {

    private static void unzipDirWithFiles(String fileForUnzip) throws Exception {
        // это архив
        ZipFile zipFile = new ZipFile(fileForUnzip);
        // папка для разархивации
        var dirForUnzip = new File(zipFile.getName()).getParent() + "/";
        // список файлов в архиве5
        var entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            // берём следующий элемент
            ZipEntry entry = entries.nextElement();
            // если это папка
            // в zip файлах isDirectory() не видит папок, поэтому ищем через слэш
            if (entry.getName().endsWith("/")) {
                System.out.println(entry.getName() + " - это папка");
                String newDirectoryPath = dirForUnzip + entry.getName();
                System.out.println("Пусть к файлу в папке " + newDirectoryPath);
                File newDir = new File(newDirectoryPath.substring(0, newDirectoryPath.lastIndexOf("/")+1));
                if(!newDir.exists()) newDir.mkdirs();
                continue;
            }
            // если это не папка
            var bis = new BufferedInputStream(zipFile.getInputStream(entry), 1024);
            String uncompressedFileName = dirForUnzip + entry.getName();

            var bos = new BufferedOutputStream(new FileOutputStream(uncompressedFileName));
            while (bis.available() > 0) {
                bos.write(bis.read());
            }
            System.out.println("Записан файл: " + entry.getName());

            bis.close();
            bos.close();
        }
        System.out.println("Zip файл разархивирован!");
    }

    public static void main(String[] args) {
        String fileForUnzip = "C:/Users/Sanchio/Desktop/dirForJRTasks/6/archive.zip";

        try {
            unzipDirWithFiles(fileForUnzip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
