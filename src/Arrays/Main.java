package Arrays;

public class Main {

    public static void rectangleCounter(byte[][] a){
        int recCount = 0;

        // копируем массив
        byte[][] aCopy = new byte[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                aCopy[i][j] = a[i][j];
            }
        }
        arrayToDisplay(aCopy, "Массив взят в работу");
        // ---------------------------------------------------

        for(int i = 0; i < aCopy.length; i++) {
            for (int j = 0; j < aCopy[i].length; j++) {
                if(aCopy[i][j] == 1){

                    // координаты верхнего левого угла меняем на 2
                    int jStart = j;
                    int iStart = i;
                    aCopy[iStart][jStart] = 2;

                    int jFin = jStart;
                    int iFin = iStart;

                    // Нашли jFin
                    while (jFin < aCopy[i].length-1){
                        if(aCopy[iFin][jFin+1] == 1){
                            jFin++;
                            aCopy[iFin][jFin] = 3;
                        } else break;
                    }


                    // Находим iFin
                    while(iFin < aCopy.length-1){
                        if(aCopy[iFin+1][jFin] == 1){
                            iFin++;
                            aCopy[iFin][jFin] = 3;
                        } else break;
                    }

                    for(int d1 = iStart; d1 <= iFin; d1++){
                        for(int d2 = jStart; d2 <= jFin; d2++){
                           aCopy[d1][d2] = 5;
                        }
                    }

                    recCount++;




                }
            }
        }

        System.out.println("Насчитано прямоугольников: " + recCount);
    }

    public static void arrayToDisplay(byte[][] a, String comment){
        System.out.println("-------------------");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(comment + "\n" + "-------------------");
    }

    public static void main(String[] args) {

//        byte[][] arr = new byte[][]{
//                {1,1,0,0},
//                {1,1,0,0},
//                {1,1,0,0},
//                {1,1,0,1}
//        };

        byte[][] arr = new byte[][]{
                {1,0,0,1},
                {0,0,0,0},
                {0,0,0,0},
                {1,0,0,1}
        };

        rectangleCounter(arr);

    }
}
