package Finished;

public class MaxSquare {
    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        if (x == 0||y == 0) return 0;
        int k_record;
        int max = 0;
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = max>dp[i][0]?max:dp[i][0];
        }
        for (int i = 1; i < y; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = max>dp[0][i]?max:dp[0][i];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][j]=='0'){
                    dp[i][j] = 0;
                }
                else {
                    k_record = 0;
                    for (int k = 1; k <= dp[i - 1][j - 1]; k++) {
                        if (matrix[i][j - k]!='1'||matrix[i-k][j]!='1') {

                            break;
                        }
                        k_record = k;
                    }
                    dp[i][j] = 1+k_record;
                    max = max>dp[i][j]?max:dp[i][j];
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        MaxSquare maxSquare = new MaxSquare();
//        System.out.println(maxSquare.maximalSquare(new char[][]{{'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'},}));
        System.out.println(maxSquare.maximalSquare(new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}));
    }
}
