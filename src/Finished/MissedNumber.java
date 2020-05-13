package Finished;

public class MissedNumber {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了62.52%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            nums[0] ^= i;
        }
        return nums[0];
    }
}
