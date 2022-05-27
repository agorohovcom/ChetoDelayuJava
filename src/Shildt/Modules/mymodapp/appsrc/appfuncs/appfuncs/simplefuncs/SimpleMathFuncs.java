package Shildt.Modules.mymodapp.appsrc.appfuncs.appfuncs.simplefuncs;

public class SimpleMathFuncs {

    //выяснить, является ли a множителем b
    public static boolean isFactor(int a, int b){
        if((b%a)==0) return true;
        return false;
    }

    //возвратить наименьший общий для a и b
    //положительный множитель
    public static int lcf(int a, int b){
        //получить абсолютные значения
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a < b ? a : b;

        for(int i = 2; i <= min/2; i++){
            if(isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }

    //возвратить наибольший общий для a и b
    //положительный множитель
    public static int gcf(int a, int b){
        //получить абсолютные значения
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a < b ? a : b;

        for(int i = min/2; i >= 2; i--){
            if(isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }
}
