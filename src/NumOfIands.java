public class NumOfIands {
    /**计算网格中岛屿的数量
     * 执行用时 :104 ms, 在所有 Java 提交中击败了5.38%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int height = grid.length;
        if(height==0) return 0;
        int width = grid[0].length;
        int num = 0;
        int[][] mark = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j]=='1'&&mark[i][j]==0){
                    //以它为起点标记所有连通的点
                    mark[i][j] = ++num;
                    mark_around(grid,mark,i,j,num,height,width);

                }
            }
        }
        return num;
    }
    public static  void mark_around(char[][]grid,int[][] mark,int i,int j,int mark_value,int height,int width) {
        if (i > 0) {
            //上面有
            if (mark[i - 1][j] == 0 && grid[i - 1][j] == '1') {
                mark[i - 1][j] = mark_value;
                //System.out.println((i-1)+" "+j+"mark"+mark_value);
                mark_around(grid, mark, i - 1, j, mark_value, height, width);

            }
        }
        if (i < height - 1) {
            //下面有
            System.out.println(i+" "+j);
            if (mark[i + 1][j] == 0 && grid[i + 1][j] == '1') {
                mark[i + 1][j] = mark_value;
                mark_around(grid, mark, i + 1, j, mark_value, height, width);

            }
        }
        if (j > 0) {
            //左边有
            if (mark[i][j - 1] == 0 && grid[i][j - 1] == '1') {
                mark[i][j - 1] = mark_value;
                mark_around(grid, mark, i, j - 1, mark_value, height, width);

            }
        }
        if (j < width - 1){
            //右边有
            if (mark[i][j + 1] == 0 && grid[i][j + 1] == '1') {
                mark[i][j + 1] = mark_value;
                mark_around(grid, mark, i, j + 1, mark_value, height, width);

            }
        }
    }
    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        System.out.println(numIslands(grid));
    }
}
