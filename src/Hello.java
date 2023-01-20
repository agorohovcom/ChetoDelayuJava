import java.io.FileNotFoundException;
import java.io.IOException;

public class Hello {
    public static void main(String[] args) {
        try {
            foo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void foo() throws  FileNotFoundException, IOException{

    }
}
