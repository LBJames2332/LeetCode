package Finished;

public class SearchInMartrix {
    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了99.80%的用户
     * 内存消耗 :45.3 MB, 在所有 Java 提交中击败了17.86%的用户
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length-1;
        int y = 0;
        int help;
        while (x>-1&&x<matrix.length&&y>-1&&y<matrix[0].length){
            help = matrix[x][y] - target;
            if (help==0)return true;
            else if (help > 0){
                x--;
            }
            else y++;
        }
        return false;
    }
}
