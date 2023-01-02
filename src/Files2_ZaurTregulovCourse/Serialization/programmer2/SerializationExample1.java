package Files2_ZaurTregulovCourse.Serialization.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        try(ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(".\\src\\Files2_ZaurTregulovCourse\\Serialization\\employees1.bin")
        )){
            employees = (ArrayList)inputStream.readObject();
            System.out.println(employees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
