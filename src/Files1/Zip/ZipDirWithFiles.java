package Files1.Zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirWithFiles {
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! работает неправильно !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    private static void zipDirWithFiles(String sourceDir, String zipFileName) throws Exception {
        // файл архива
        File zipFile = new File(sourceDir + "/" + zipFileName);

        // Создание объекта ZipOutputStream
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));

        // Создание объекта File object архивируемой директории
        File fileSource = new File(sourceDir);

        addDirectory(zos, fileSource, zipFile);

        zos.close();
        System.out.println("Zip файл создан!");
    }

    private static void addDirectory(ZipOutputStream zos, File fileSource, File currentZipFile) throws Exception {
        // массив всех файлов в папке
        File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for (int i = 0; i < files.length; i++) {
            // Если f является директорией, то рекурсивно вызываем
            // метод addDirectory
            if (files[i].isDirectory()) {
                addDirectory(zos, files[i], currentZipFile);
                continue;
            }
            if(!files[i].equals(currentZipFile)) {
                System.out.println("Добавление файла <" + files[i].getName() + ">");
                FileInputStream fis = new FileInputStream(files[i]);


                zos.putNextEntry(new ZipEntry(files[i].getPath()));

                byte[] buff = new byte[4096];
                int c;
                while ((c = fis.read(buff)) > 0) {
                    zos.write(buff, 0, c);
                }
                fis.close();
            }
        }
        zos.closeEntry();
    }


    public static void main(String[] args) {
        // Папка, содержимое которой надо добавить в архив
        String sourceDir = "C:/Users/Sanchio/Desktop/dirForJRTasks/6";
        // Имя архива
        String zipFileName = "archive.zip";

        try {
            zipDirWithFiles(sourceDir, zipFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
