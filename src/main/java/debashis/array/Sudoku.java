package debashis.array;

import java.util.*;

public class Sudoku {

    public static void main(String[] args){
        Sudoku sudoku = new Sudoku();
        int[][] matrix = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
//        System.out.println(sudoku.fetchSets(matrix,0,8).toString());
        if(sudoku.execute(matrix,0,0)){
            Arrays.stream(matrix).forEach(v -> {
                Arrays.stream(v).forEach(h -> System.out.print(h + " "));
                System.out.println();
            });
        }else{
            System.out.println("No solution");
        }

    }

    private boolean execute(int[][] matrix,int i,int j){
        if(i == matrix.length-1 && j == matrix[0].length){
            return true;
        }
        if(j == matrix[0].length){
            i=i+1;
            j=0;
        }
        if(matrix[i][j] != 0){
            return execute(matrix,i,j+1);
        }
        for(int v=1;v<=9;v++){
            if(!checkIfPresent(matrix,v,i,j)){
                matrix[i][j] = v;
                if(execute(matrix,i,j+1)){
                    return true;
                }
            }
            matrix[i][j] = 0;
        }
        return false;
    }

    private boolean checkIfPresent(int[][] matrix, int v, int i, int j) {
        for(int m=0;m<9;m++){
            if(matrix[i][m] == v || matrix[m][j] == v){
                return true;
            }
        }
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if(matrix[(i/3)*3 + k][(j%3)*3 + l] == v){
                    return true;
                }
            }
        }
        return false;
    }

}
