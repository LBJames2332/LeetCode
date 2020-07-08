package Finished;

public class CountNegativeInSMatrix {
    public int countNegatives(int[][] grid) {
        int pos = grid[0].length-1;
        int count = 0;
        for (int i = 0; i < grid.length ; i++) {
            while (pos>=0&&grid[i][pos]<0) pos--;
            count+=grid[0].length-pos-1;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(new CountNegativeInSMatrix().countNegatives(new int[][]{
                {5,1,0},
                {-5,-5,-5}
        }));
    }
}
