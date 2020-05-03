package Finished;

public class MaxSubArray {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了33.71%的用户
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int count = 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(count > 0 ){
                count = count + nums[i];
            }
            else count = nums[i];
            max = (max >count)?max:count;
        }
        return max;
    }
}
