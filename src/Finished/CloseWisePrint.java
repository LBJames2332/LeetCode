package Finished;

import java.util.Arrays;

public class CloseWisePrint {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了97.18%的用户
     * 内存消耗 :41.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return new int[0];

        int[] ans = new int[matrix.length*matrix[0].length];
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        int curr_loop = 0;
        int curr = 0;
        int loops = Math.min(down,right)>>1;
        while (curr_loop<= loops){
            for (int i = curr_loop; i <= right; i++) {
                //->
                ans[curr++] = matrix[curr_loop][i];
            }
            if (curr_loop==down) break;
            for (int i = curr_loop+1; i <= down; i++) {
                //down
                ans[curr++] = matrix[i][right];
            }
            for (int i = right-1; i >= curr_loop; i--) {
                //<-
                ans[curr++] = matrix[down][i];
            }
            if (right==curr_loop)break;
            for (int i = down-1; i > curr_loop; i--) {
                //up
                ans[curr++] = matrix[i][curr_loop];
            }
            curr_loop++;
            right--;
            down--;
        }
        return ans;
    }

    public static void main(String[] args) {
        CloseWisePrint closeWisePrint = new CloseWisePrint();
        System.out.println(Arrays.toString(closeWisePrint.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
    }
}
