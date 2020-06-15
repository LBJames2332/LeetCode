package Finished;

public class ReverseMatrix {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int half = N>>1;
        int[] help;
        int hel;
        for (int i = 0; i < half; i++) {
            help = matrix[i];
            matrix[i] = matrix[N-1-i];
            matrix[N-1-i] = help;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                hel = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = hel;
            }
        }

        
    }

    public static void main(String[] args) {
        new ReverseMatrix().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    
}
