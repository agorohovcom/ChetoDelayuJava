package Files2_ZaurTregulovCourse.InterfacePathAndClassFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PathAndFilesExample1 {
    public static void main(String[] args) throws IOException {
        // файл
//        Path filePath = Paths.get("testPathAndFiles.txt");
        Path filePath = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\testPathAndFiles.txt");
        // папка
        Path directoryPath = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\m");

        // getFileName() - имя файла или папки
        System.out.println("filePath.getFileName(): " + filePath.getFileName());
        System.out.println("directoryPath.getFileName(): " + directoryPath.getFileName());
        System.out.println("-----------------------------------");

        // getParent()
        // если Path задаётся через относительный путь, родителя файла не будет
        System.out.println("filePath.getParent(): " + filePath.getParent());
        System.out.println("directoryPath.getParent(): " + directoryPath.getParent());
        System.out.println("-----------------------------------");

        // getRoot() - показывает корень для относительно заданных Path
        System.out.println("filePath.getRoot(): " + filePath.getRoot());
        System.out.println("directoryPath.getRoot(): " + directoryPath.getRoot());
        System.out.println("-----------------------------------");

        // isAbsolute() - работаем ли мы с абсолютным путём
        System.out.println("filePath.isAbsolute(): " + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute(): " + directoryPath.isAbsolute());
        System.out.println("-----------------------------------");

        // toAbsolutePath() - делает путь абсолютным
        System.out.println("filePath.toAbsolutePath(): " + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath(): " + directoryPath.toAbsolutePath());

        System.out.println("filePath.toAbsolutePath().getParent(): " + filePath.toAbsolutePath().getParent());
        System.out.println("directoryPath.toAbsolutePath().getRoot(): " + directoryPath.toAbsolutePath().getRoot());
        System.out.println("-----------------------------------");

        // normalize() - делает путь нормальным (убирает всякие точки)
        System.out.println("filePath.normalize(): " + filePath.normalize());
        System.out.println("directoryPath.normalize(): " + directoryPath.normalize());
        System.out.println("-----------------------------------");

        // resolve() - объединяет пути
        // если бы путь к файлу относительный, то resolve() "поместит" его в папку
        System.out.println("directoryPath.resolve(filePath): " + directoryPath.resolve(filePath));
        System.out.println("-----------------------------------");

        // другой файл
        Path anotherPath = Paths.get(".\\src\\Files2_ZaurTregulovCourse\\InterfacePathAndClassFiles\\m\\n\\z\\anotherFile.txt");

        // relativize() - показывает путь к anotherPath относительно directoryPath
        System.out.println("directoryPath.relativize(anotherPath): " + directoryPath.relativize(anotherPath));
        System.out.println("-----------------------------------");

        // Files.exists() - существует ли файл\папки
        // Files.createFile - создать файл
        // Files.createDirectory - создать папку
        if(!Files.exists(filePath)){
            Files.createFile(filePath);
        }
        if(!Files.exists(directoryPath)){
            Files.createDirectory(directoryPath);
        }

        // проверка прав
        System.out.println("Files.isReadable(filePath): " + Files.isReadable(filePath));
        System.out.println("Files.isReadable(filePath): " + Files.isWritable(filePath));
        System.out.println("Files.isReadable(filePath): " + Files.isExecutable(filePath));
        System.out.println("-----------------------------------");

        // isSameFile() - покажет true, если оба Path ссылаются на один и тот же файл
        // даже если один путь абсолютный, а другой относительный
        System.out.println("Files.isSameFile(directoryPath, filePath): " + Files.isSameFile(directoryPath, filePath));
        System.out.println("-----------------------------------");

        // Files.size() - размер файла в байтах
        System.out.println("Files.size(filePath): " + Files.size(filePath));
        System.out.println("-----------------------------------");

        // Files.getAttribute()
        // Files.readAttributes(path, "*") - узнать все атрибуты
        System.out.println("Files.getAttribute(filePath, \"size\"): " + Files.getAttribute(filePath, "size"));
        System.out.println("Files.getAttribute(filePath, \"creationTime\"): " + Files.getAttribute(filePath, "creationTime"));
        System.out.println("Files.readAttributes(filePath, \"*\"): " + Files.readAttributes(filePath, "*"));
        // или так
        Map<String, Object> attributes = Files.readAttributes(filePath, "*");
        for(Map.Entry<String, Object> entry : attributes.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("-----------------------------------");
    }
}
