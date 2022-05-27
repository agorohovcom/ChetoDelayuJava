package LinkToMethInMethParameter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String [] array = new String[]{"hello", "world"};

        changeStringArray(array, String::toUpperCase);

        System.out.println(Arrays.toString(array));
    }

    public static void changeStringArray(String[] array, StringModificationFunction smf){
        for(int i = 0; i < array.length; i++){
            array[i] = smf.modification(array[i]);
        }
    }
}
