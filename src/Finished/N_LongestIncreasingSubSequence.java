package Finished;

public class N_LongestIncreasingSubSequence {
    /**
     * 执行用时 :21 ms, 在所有 Java 提交中击败了43.72%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了11.11%的用户
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int lenth = nums.length;
        int[]dp = new int[lenth];
        int[]count = new int[lenth];
        int max;
        int count_1 = 0;
        int m_length = 0;
        for (int i = 0; i < lenth; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    if (dp[j] > max){
                        max =dp[j];
                        count[i] = count[j];
                    }
                    else {
                        if (dp[j]==max) count[i] += count[j];
                    }
                }

            }
            dp[i] = 1+max;
            if (max == 0) count[i] = 1;
            if (dp[i] == m_length) {
                count_1 += count[i];
            }
            else {
                if (dp[i] > m_length) {
                    count_1 = count[i];
                    m_length =dp[i];
                }

            }

        }
        return count_1;
    }

    public static void main(String[] args) {
        N_LongestIncreasingSubSequence n_longestIncreasingSubSequence = new N_LongestIncreasingSubSequence();
        System.out.println(n_longestIncreasingSubSequence.findNumberOfLIS(new int[]{1,2,3,1,2,3,1,2,3}));
    }
}
