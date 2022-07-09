package Arrays.ForTetris;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 0, 1, 1},
                {0, 2, 0, 2, 2},
                {3, 3, 3, 3, 3},            // полная строка
                {0, 4, 0, 4, 0},
                {0, 0, 0, 0, 0},
                {6, 6, 6, 6, 6},            // полная строка
                {0, 0, 7, 0, 7}
        };
        int height = matrix.length;
        int width = matrix[0].length;

        System.out.println("\nИзначальная матрица:\n");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // ---------------------------------------------------

//        System.out.println("\nМеняем полные строки на 9:\n");
//        for (int i = 0; i < height; i++) {
//            boolean isFullLine = true;
//            for (int j = 0; j < width; j++) {
//                if(matrix[i][j] == 0){
//                    isFullLine = false;
//                }
//            }
//            if(isFullLine){
//                matrix[i] = new int[]{9, 9, 9, 9, 9};
//            }
//        }


        System.out.println("\nКидаем неполные строки в список:\n");
        List<int []> list = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            boolean isFullLine = true;
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] == 0){
                    isFullLine = false;
                }
            }
            if(!isFullLine){
                list.add(matrix[i]);
            }
        }

        // количество удалённых строк (полных)
        int countEmptyLine = matrix.length - list.size();

        // массив - пустая строка
        int [] emptyLine = new int[matrix[0].length];
        for(int i = 0; i < emptyLine.length; i++){
            emptyLine[i] = 0;
        }


        for(int i = 0; i < countEmptyLine; i++){
            list.add(0, emptyLine);
        }

        for(int i = 0; i < height; i++){
            matrix[i] = list.get(i);
        }


        // ---------------------------------------------------
        System.out.println("\nКонечная матрица:\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
