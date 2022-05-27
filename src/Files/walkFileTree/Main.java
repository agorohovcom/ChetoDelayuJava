package Files.walkFileTree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

public class Main {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> filesList = new ArrayList<>();

        // 1. Через Files.walkFileTree
        class MyVisitor extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(Files.isRegularFile(file)){
                    filesList.add(file.toFile().getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        }

        Files.walkFileTree(Paths.get(root), new MyVisitor());

//        // Через Queue
//        Queue<File> queue = new PriorityQueue<>();
//        File rootFile = new File(root);
//        Collections.addAll(queue, rootFile.listFiles());
//
//        while (!queue.isEmpty()){
//            File file = queue.remove();
//            if(file.isDirectory()){
//                Collections.addAll(queue, file.listFiles());
//            }
//            if(file.isFile()) list.add(file.getAbsolutePath());
//        }
        return filesList;
    }

    public static void main(String[] args) throws IOException {
        String s = "D:\\";
        List<String> list = getFileTree(s);

        for(String d : list) System.out.println(d);
        System.out.println(list.size());
    }
}
