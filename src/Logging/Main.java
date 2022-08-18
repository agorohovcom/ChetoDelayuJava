package Logging;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MyObj> myObjList = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            myObjList.add(new MyObj(i, "MyObjInstance#" + i));
        }

    }
}
