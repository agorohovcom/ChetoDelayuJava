package Files2_ZaurTregulovCourse.Serialization.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample2 {
    public static void main(String[] args) {
        Car car = new Car("Nissat Tiida", "white");
        Employee employee = new Employee("Mariya", "IT", 28, 500, car);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(".\\src\\Files2_ZaurTregulovCourse\\Serialization\\employees2.bin"))){
            outputStream.writeObject(employee);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
