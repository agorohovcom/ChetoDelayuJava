package Files2_ZaurTregulovCourse.File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File(
                ".\\src\\Files2_ZaurTregulovCourse\\File\\file.txt");
        File folder = new File(
                ".\\src\\Files2_ZaurTregulovCourse\\File\\A");
        File file2 = new File(
                ".\\src\\Files2_ZaurTregulovCourse\\File\\A\\file2.txt");
        File folder2 = new File(
                ".\\src\\Files2_ZaurTregulovCourse\\File\\B");

        // getAbsolutePath() абсолютный путь
        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() " + folder.getAbsolutePath());
        System.out.println("--------------------------");

        // isAbsolute() абсолютный ли путь
        System.out.println("file.isAbsolute() " + file.isAbsolute());
        System.out.println("folder.isAbsolute() " + folder.isAbsolute());
        System.out.println("--------------------------");

        // isDirectory() является ли директорией
        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("folder.isDirectory() " + folder.isDirectory());
        System.out.println("--------------------------");

        // exists() существует ли
        System.out.println("file.exists() " + file.exists());
        System.out.println("folder.exists() " + folder.exists());
        System.out.println("file2.exists() " + file2.exists());
        System.out.println("folder2.exists() " + folder2.exists());
        System.out.println("--------------------------");

        // createNewFile() и mkdir() - создать файл и директорию
        System.out.println("file2.createNewFile() " + file2.createNewFile());
        System.out.println("folder2.mkdir() " + folder2.mkdir());
        System.out.println("--------------------------");

        // length() - узнать размер
        System.out.println("file2.length() " + file2.length());
        System.out.println("folder.length() " + folder.length());
        System.out.println("--------------------------");

        // delete() - удалить
        // папку можно удалить, только если она пуста
        System.out.println("folder.delete() " + folder.delete());
        System.out.println("folder2.delete() " + folder2.delete());
        System.out.println("file2.delete() " + file2.delete());
        System.out.println("--------------------------");

        // listFiles() - возвращает массив File[] с содержимым папки
        File[] files = folder.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println("--------------------------");

        // isHidden() - скрыт ли файл
        // canRead() - можно ли читать
        // canWrite() - можно ли писать
        // canExecute() - если ли права запустить
        System.out.println("file2.isHidden() " + file2.isHidden());
        System.out.println("file2.canRead() " + file2.canRead());
        System.out.println("file2.canWrite() " + file2.canWrite());
        System.out.println("file2.canExecute() " + file2.canExecute());
        System.out.println("--------------------------");


    }
}
