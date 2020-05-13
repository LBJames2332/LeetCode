package Finished;

public class OnlyOnce {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.75%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了5.71%的用户
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0]^=nums[i];
        }
        return nums[0];
    }
}
