package Finished;

public class ShortestPathInA_Net {
    //网格中的最短路径问题
    //DFS法
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了95.25%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    private static boolean[][] visited;
    private static int min_length = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(shortestPath(new int[][]{{0,0,0},
                                                    {1,1,0},
                                                    {0,0,0},
                                                    {0,1,1},
                                                    {0,0,0}},1));
    }
    public static int shortestPath(int[][] grid, int k) {
        //标记已经过的点，若是重复点，return
        visited = new boolean[grid.length][grid[0].length];
        dfs(0,0,grid.length-1,grid[0].length-1,grid,k,0);
        if(min_length > grid.length*grid[0].length) min_length = -1;
        return min_length;
    }
    public static void dfs(int row,int col,int end_x,int end_y,int [][]grid,int k,int length){
        if (row<0||col<0||row>=grid.length||col>=grid[0].length||length+1+end_x-row+end_y-col>=min_length){
            //这个判断的最后一项，假设你走到当前位置合法，但即使你之后不遇到任何障碍都不够快，直接return掉
            //核心判断1
            return;
        }

        if (grid[row][col]==1){
            if ((--k)<0) return;
            //是一个障碍物，走的话会 超时，return掉
        }
        int leftBarriers = end_x+end_y-row-col - 1;
        if(k>=leftBarriers){
            //这个部分，如果你在当前位置，k足够你任意挥霍，直接计算结果并return
            //核心判断2
            min_length = (min_length>(length+leftBarriers+1)?(length+leftBarriers+1):min_length);
        }
        if (k >= end_x+end_y-row-col - 1) {

        }
        if (visited[row][col]) return;
        if (row==end_x&&col==end_y) {
            min_length = (min_length>length)?length:min_length;
            return;
        }
        //往上走

        visited[row][col] = true;
        length++;
        dfs(row-1,col,end_x,end_y,grid,k,length);//走了试试看，先走再说，不对return

        //往下走
        dfs(row+1,col,end_x,end_y,grid,k,length);

        //往左走
        dfs(row,col-1,end_x,end_y,grid,k,length);

        //往右走
        dfs(row,col+1,end_x,end_y,grid,k,length);
        visited[row][col] = false;

    }
}
