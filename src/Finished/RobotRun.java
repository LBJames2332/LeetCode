package Finished;

public class RobotRun {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了6.35%的用户
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        for (int i = 0; i < m; i++) {
            ways[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ways[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j] = ways[i-1][j]+ways[i][j-1];
            }
        }
        return ways[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new RobotRun().uniquePaths(3,7));
    }
}
