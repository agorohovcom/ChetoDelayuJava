package Files2_ZaurTregulovCourse;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно, —\n" +
                "Вот последний секрет из постигнутых мной.\n";
        String s = "Привет";
        FileWriter writer = null;
        try {
            // абсолютный путь
//            writer = new FileWriter("C:\\Users\\Александр\\Desktop\\filesForCourse\\file1.txt");
            // относительный путь
            // так файл будет создан в корне проекта
//            writer = new FileWriter("test2.txt", true);
            writer = new FileWriter(".\\src\\Files2_ZaurTregulovCourse\\test1.txt", true);

            // способ 1 - посимвольная передача
//            for(int i = 0; i < rubai.length(); i++){
//                writer.write(rubai.charAt(i));
//            }

            // способ 2 - передача строки (но тоже посимвольно)
            writer.write(rubai);
            writer.write(s);



            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }
}
