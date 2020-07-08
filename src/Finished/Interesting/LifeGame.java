package Finished.Interesting;

import java.util.Arrays;

public class LifeGame {
    int X;
    int Y;
    int[][]BOARD;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了11.11%的用户
     * @param board
     */
    public void gameOfLife(int[][] board) {
        BOARD = board;
        X = board.length;
        Y = board[0].length;
        int count;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                count = count(i,j);
                if (board[i][j]==1){//活细胞
                    if (count==2||count==3){
                        board[i][j] |= 2;
                    }
                }
                else {
                    if (count==3){
                        board[i][j] |= 2;
                    }
                }
            }
        }
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
        for (int i = 0; i < X; i++) {

            System.out.println(Arrays.toString(board[i]));
        }
    }


    private byte count(int x,int y){

        return (byte) (getVal(x-1,y)+
                getVal(x+1,y)+
                getVal(x,y-1)+
                getVal(x,y+1)+
                getVal(x-1,y-1)+
                getVal(x-1,y+1)+
                getVal(x+1,y-1)+
                getVal(x+1,y+1));
    }


    private byte getVal(int x,int y){
        if (x < 0||x == X) return 0;
        if (y < 0||y == Y) return 0;
        return (byte) (BOARD[x][y]&1);
    }

    public static void main(String[] args) {
        new LifeGame().gameOfLife(new int[][]{
                {0,1,0},
        {0,0,1},
        {1,1,1},
        {0,0,0}

        });
    }

}
