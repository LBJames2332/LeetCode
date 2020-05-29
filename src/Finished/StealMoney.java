package Finished;

public class StealMoney {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了6.52%的用户
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);

        int[]dp = new int[nums.length];
        //dp存储的是以它为最后偷取的一家能偷到的最大金额
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i]+Math.max(dp[i-2],dp[i-3]);
        }
        return Math.max(dp[dp.length-1],dp[dp.length-1]);
        //最后两家一定要偷一家，因为假如我最后两家一家都不偷，一定会有一家我能不触发警报的我没去偷，太可惜了。
    }
}
