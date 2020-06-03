package Finished;

public class MinimumPathWeight {
    /**
     * 暴力递归
     */
    int[][] GRID;
    int r_max;
    int c_max;
    int min;
    boolean marked;
    public int minPathSum(int[][] grid) {
        GRID = grid;
        r_max = grid.length;
        c_max = grid[0].length;
        process(0,0,0);
        return min;
    }

    private void process(int c_r, int c_c, int weight) {
        if (c_r==r_max) return;
        if (c_c==c_max) return;
        weight += GRID[c_r][c_c];
        if (c_c==c_max-1&&c_r==r_max-1) {
            if (!marked){
                min = weight;
                marked = true;
            }
            else min = (min < weight)?min:weight;
        }
        process(c_r+1,c_c,weight);
        process(c_r,c_c+1,weight);
    }


    public static void main(String[] args) {
        MinimumPathWeight minimumPathWeight = new MinimumPathWeight();
        System.out.println(minimumPathWeight.minPathSum(new int[][]{{1,2},
            {1,1}}));
    }
}
