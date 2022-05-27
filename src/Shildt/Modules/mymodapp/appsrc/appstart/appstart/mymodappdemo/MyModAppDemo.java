package Shildt.Modules.mymodapp.appsrc.appstart.appstart.mymodappdemo;

import Shildt.Modules.mymodapp.appsrc.appfuncs.appfuncs.simplefuncs.SimpleMathFuncs;

public class MyModAppDemo {
    public static void main(String[] args){

        if(SimpleMathFuncs.isFactor(2, 10))
            System.out.println("2 - множитель 10");

        System.out.println("Наименьший общий множитель " +
                "35 и 105 - " +
                SimpleMathFuncs.lcf(35, 105));

        System.out.println("Наибольший общий множитель " +
                "35 и 105 - " +
                SimpleMathFuncs.gcf(35,105));

    }
}
