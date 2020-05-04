package Finished;

public class IncreasingTriplet {
    /**
     * 寻找递增子序列，双指针法，细品
     * 执行用时 :1 ms, 在所有 Java 提交中击败了66.40%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int mid = 0;
        boolean m_seted = false;
        int small = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < small) small = nums[i];
            else if (nums[i]>small){
                if (!m_seted){
                    mid = nums[i];
                }
                else {
                    if (nums[i] < mid) mid = nums[i];
                    else if (nums[i] > mid) return true;
                }
            }
        }
        return false;
    }
}
