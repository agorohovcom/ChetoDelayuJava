package Files2_ZaurTregulovCourse.FileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTreeExample1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/Files2_ZaurTregulovCourse/FileTree/X");
        Files.walkFileTree(path, new MyFileVisitor());
    }
}

class MyFileVisitor implements FileVisitor<Path>{
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter do directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error while visiting file: " + file.getFileName());
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from directory: " + dir);
        return FileVisitResult.CONTINUE;
    }
}

// Output:

//    Enter do directory: src\Files2_ZaurTregulovCourse\FileTree\X
//    Enter do directory: src\Files2_ZaurTregulovCourse\FileTree\X\Y1
//    Enter do directory: src\Files2_ZaurTregulovCourse\FileTree\X\Y1\O
//    Exit from directory: src\Files2_ZaurTregulovCourse\FileTree\X\Y1\O
//    File name: test1.txt
//    File name: test2.txt
//    File name: test3.txt
//    Exit from directory: src\Files2_ZaurTregulovCourse\FileTree\X\Y1
//    Enter do directory: src\Files2_ZaurTregulovCourse\FileTree\X\Y2
//    File name: test4.txt
//    Exit from directory: src\Files2_ZaurTregulovCourse\FileTree\X\Y2
//    Enter do directory: src\Files2_ZaurTregulovCourse\FileTree\X\Z
//    Exit from directory: src\Files2_ZaurTregulovCourse\FileTree\X\Z
//    Exit from directory: src\Files2_ZaurTregulovCourse\FileTree\X