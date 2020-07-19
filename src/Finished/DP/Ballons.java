package Finished.DP;

import java.util.ArrayList;
import java.util.List;

public class Ballons {
    int[][] dp;
    int[] center;
    //只需要算上三角即可

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了5.66%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了25.00%的用户
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        List<Integer> ll = new ArrayList<>(nums.length+2);
        ll.add(1);
        for (int i:nums) ll.add(i);
        ll.add(1);
        dp = new int[nums.length+2][nums.length+2];
        for (int i = dp.length-1; i > -1; i--) {
            for (int j = i+1; j < dp.length; j++) {
                int max = 0;//0 ≤ nums[i] ≤ 100
                for (int k = i+1; k < j; k++) {
                    /**
                     * 在i~j之间的每个位置上尝试
                     * 就是说在（i,j）上玩游戏的话最高得分若是最后拿k位置的，则分数为（i,k）上的得分+（k,j）上的得分+N(k)*N(i)*N(j)
                     */
                    max = Math.max(max,dp[i][k]+dp[k][j]+ll.get(k)*ll.get(i)*ll.get(j));
                }
                dp[i][j] = max;
            }
        }
        return dp[0][dp.length-1];
    }
    public static void main(String[] args) {
        System.out.println(new Ballons().maxCoins(new int[]{3,1,5,8}));
    }
}
