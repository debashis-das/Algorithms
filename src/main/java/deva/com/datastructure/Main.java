package deva.com.datastructure;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        Main main = new Main();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        main.gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        int[][] temp1 = new int[2][board[0].length];
        int[][] indexs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int copyIndex = 0;
        for(int i=0;i<board.length;i++){
            if(i-2 >= 0){
                for(int j=0;j<board[i].length;j++) {
                    board[i-2][j] = temp1[copyIndex%2][j];
                }
            }
            for(int j=0;j<board[i].length;j++){
                int countOne = 0;
                for(int k=0;k<indexs.length;k++){
                    int tempx = i + indexs[k][0];
                    int tempy = j + indexs[k][1];
                    if(tempx < 0 || tempx >= board.length || tempy < 0 || tempy >= board[i].length){
                        continue;
                    }
                    if(board[tempx][tempy] == 1){
                        ++countOne;
                    }
                }
                if(board[i][j] == 1 && countOne < 2){
                    temp1[copyIndex%2][j] = 0;
                }else if(board[i][j] == 1 && countOne <= 3){
                    temp1[copyIndex%2][j] = 1;
                }else if(board[i][j] == 1 && countOne > 3){
                    temp1[copyIndex%2][j] = 0;
                }else if(board[i][j] == 0 && countOne == 3){
                    temp1[copyIndex%2][j] = 1;
                }else{
                    temp1[copyIndex%2][j] = board[i][j];
                }

            }
            // System.out.println(Arrays.toString(temp1[copyIndex%2]));
            ++copyIndex;
        }
        board[board.length-2] = temp1[(board.length-2)%2];
        board[board.length-1] = temp1[(board.length-1)%2];
//        System.out.println("--------------------");
//        for(int i=0;i<board.length;i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }
}
