package Files2_ZaurTregulovCourse;

import java.io.*;

public class CopyExample {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(
                new FileReader(".\\src\\Files2_ZaurTregulovCourse\\test1.txt"));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(".\\src\\Files2_ZaurTregulovCourse\\test2.txt"))){

            // вариант 1 - посимвольно
//            int character;
//            while ((character = reader.read()) != -1){
//                writer.write(character);
//            }

            // вариант 2 - построчно
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.write("\n");
            }


            System.out.println();
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
