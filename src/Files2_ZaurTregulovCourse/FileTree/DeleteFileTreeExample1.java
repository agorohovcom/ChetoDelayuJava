package Files2_ZaurTregulovCourse.FileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFileTreeExample1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/Files2_ZaurTregulovCourse/FileTree/CopyXHere");
        Files.walkFileTree(path, new MyFileVisitor3());
    }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Delete file: " + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Delete directory: " + dir.getFileName());
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}

// Output:

//        Delete directory: O
//        Delete file: test1.txt
//        Delete file: test2.txt
//        Delete file: test3.txt
//        Delete directory: Y1
//        Delete file: test4.txt
//        Delete directory: Y2
//        Delete directory: Z
//        Delete directory: CopyXHere