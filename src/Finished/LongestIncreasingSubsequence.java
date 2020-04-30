package Finished;

public class LongestIncreasingSubsequence {
    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了71.82%的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了7.14%的用户
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        int max;
        for (int i = 0; i < nums.length; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) max = (max > count[j])?max:count[j];
            }
            count[i] = max+1;
        }
        max = 0;
        for (int j = 0; j < nums.length; j++) {
            max = (max > count[j])?max:count[j];
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
