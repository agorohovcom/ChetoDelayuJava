package Files2_ZaurTregulovCourse.Serialization.programmer2;

import Files2_ZaurTregulovCourse.Serialization.programmer1.Employee;

import java.io.*;

public class SerializationExample2 {
    public static void main(String[] args) {
        Employee bestEmployee;

        try(ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(".\\src\\Files2_ZaurTregulovCourse\\Serialization\\employees2.bin"))) {
            bestEmployee = (Employee) inputStream.readObject();
            System.out.println(bestEmployee);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
