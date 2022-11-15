package NestedClasses.LocalInnerClass;

import org.w3c.dom.ls.LSOutput;

/**
 * такие классы локальны для своего блока кода (метода, коструктора)
 * снаружи недоступны
 * для локального класса доступны поля внешнего класса и
 * переменные блока кода, где он находится, но такие поля должны быть
 * final или effectively final
 * параметры, передающиеся в метод, которые будут использованы в local class,
 * также должны быть final или effectively final
 */
public class LocalInner1 {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }
}

class Math{
    private String hi = "Привет из внешнего класса";
    public void getResult(){
        /*final*/ int delimoe = 21;
//        delimoe = 20;                       // менять переменную нельзя

        class Delenie{
//            public int delimoe;
            public int delitel;

//            public int getDelimoe() {
//                return delimoe;
//            }

//            public void setDelimoe(int delimoe) {
//                this.delimoe = delimoe;
//            }

            public int getDelitel() {
                return delitel;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getChastnoe(){
                return delimoe/delitel;
            }

            public int getOstatok(){
                return delimoe%delitel;
            }
        }

        // создаём объект локального класса в том же методе
        Delenie delenie = new Delenie();
//        delenie.setDelimoe(21);
        delenie.setDelitel(4);
        System.out.println("Delimoe = " + delimoe);
        System.out.println("Delitel = " + delenie.getDelitel());
        // для локального класса доступны поля внешнего класса
        System.out.println(hi);
        System.out.println("Chastnoe = " + delenie.getChastnoe());
        System.out.println("Ostatok = " + delenie.getOstatok());
    }
}