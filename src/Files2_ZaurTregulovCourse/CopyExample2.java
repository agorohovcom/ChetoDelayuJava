package Files2_ZaurTregulovCourse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample2 {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(".\\src\\Files2_ZaurTregulovCourse\\image1.jpg");
             FileOutputStream outputStream = new FileOutputStream(".\\src\\Files2_ZaurTregulovCourse\\image2.jpg")) {
            int i;
            while ((i = inputStream.read()) != -1){
                outputStream.write(i);
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
