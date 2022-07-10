package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/** К объектам, которые сериализуются/десериализуются в JSON есть несколько требований:
*        1) поля должны быть видимые: или public или иметь getter’ы и setter’ы;
*        2) должен быть конструктор по умолчанию (без параметров).
*/

public class Main {
    public static void main(String[] args) throws IOException {

        // СЕРИАЛИЗАЦИЯ ОБЪЕКТА
        System.out.println("\nСЕРИАЛИЗАЦИЯ ОБЪЕКТА В JSON\n");

        Cat cat = new Cat();
        cat.setAge(3);
        cat.setHunter(true);
        cat.setName("JacksonCat");
        System.out.println(cat);

        // писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        // это объект Jackson, который выполняет сериализацию
        ObjectMapper objectMapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        objectMapper.writeValue(writer, cat);

        // преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);

        // ДЕСЕРИАЛИЗАЦИЯ ОБЪЕКТА
        System.out.println("\nДЕСЕРИАЛИЗАЦИЯ ОБЪЕКТА ИЗ JSON\n");

        String jsonString = "{ \"name\":\"Murka\", \"age\":5, \"hunter\":false}";
        StringReader reader = new StringReader(jsonString);

        Cat cat2 = objectMapper.readValue(reader, Cat.class);
        System.out.println(cat2);
    }
}
