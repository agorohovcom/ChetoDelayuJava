package Files2_ZaurTregulovCourse;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader(".\\src\\Files2_ZaurTregulovCourse\\test1.txt")) {
            int character;
            while ((character = reader.read()) != -1){
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
