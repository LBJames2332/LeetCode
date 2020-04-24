package NotFinished;

public class LongestContinuousIncreasingSubsequence {
    /**
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列(串)。
     * 执行用时 :5 ms, 在所有 Java 提交中击败了6.06%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了12.50%的用户
     */
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
    public static int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] <= nums[j-1]) break;
                count++;
            }
            ans = (ans < count)? count:ans;
        }
        return ans;
    }
}
