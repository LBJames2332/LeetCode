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
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了89.89%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了24.24%的用户
     */
    int[][]memo;
    public int minPathSum_memo(int[][] grid) {
        GRID = grid;
        r_max = grid.length;
        c_max = grid[0].length;
        memo = new int[r_max][c_max];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < c_max; i++) {
            memo[0][i] = memo[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < r_max; i++) {
            memo[i][0] = memo[i-1][0] + grid[i][0];
            for (int j = 1; j < c_max; j++) {
                memo[i][j] = ((memo[i-1][j]>memo[i][j-1])?memo[i][j-1]:memo[i-1][j])+grid[i][j];
            }
        }
        return memo[r_max-1][c_max-1];
    }

    public static void main(String[] args) {
        MinimumPathWeight minimumPathWeight = new MinimumPathWeight();
        System.out.println(minimumPathWeight.minPathSum(new int[][]{{1,2},
            {1,1}}));
    }
}
