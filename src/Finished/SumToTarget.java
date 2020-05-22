package Finished;

public class SumToTarget {
    int[][] dp;
    int length;
    int width;

    /**
     * 执行用时 :14 ms, 在所有 Java 提交中击败了62.01%的用户
     * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        length = nums.length;
        int sum = 0;
        int help_x;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
        }
        if (S > sum) return 0;
        width = sum<<1;
        dp = new int[length+1][width+1];
        dp[0][sum] = 1;
        for (int i = 1; i < length; i++) {
            help_x = i-1;
            for (int j = 0; j < sum; j++) {
                dp[i][j] = getPos(help_x,j-nums[help_x])+getPos(help_x,j+nums[help_x]);
                dp[i][width-j] = dp[i][j];
            }
            dp[i][sum] = getPos(help_x,sum-nums[help_x])+getPos(help_x,sum+nums[help_x]);
        }
        help_x = length-1;
        for (int i = 0; i <=S+sum ; i++) {
            dp[length][i] = getPos(help_x,i-nums[help_x])+getPos(help_x,i+nums[help_x]);
        }
        return dp[length][S+sum];

    }

    public static void main(String[] args) {
        SumToTarget sumToTarget = new SumToTarget();
        System.out.println(sumToTarget.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    public int getPos(int x,int y){
        if (y > -1&&y <= width){
            return dp[x][y];
        }
        return 0;
    }
}
