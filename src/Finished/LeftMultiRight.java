package Finished;

import java.util.Arrays;

public class LeftMultiRight {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :48.2 MB, 在所有 Java 提交中击败了11.76%的用户
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0]=1;
        for (int i = 1; i < nums.length; i++) {
            ans[i]=ans[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = nums.length-1; i > -1; i--) {
            ans[i] = ans[i]*right;
            right *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LeftMultiRight leftMultiRight = new LeftMultiRight();
        System.out.println(Arrays.toString(leftMultiRight.productExceptSelf(new int[]{1,3,4,6})));
    }
}
