package Finished;

import java.util.Arrays;

public class TwoDisappearedNumber {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了35.28%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public int[] missingTwo(int[] nums) {
        int[]ans = new int[2];
        int sum = 0;
        int N = nums.length+2;
        boolean [] mark = new boolean[3];

        for (int i:nums) {
            sum+=Math.abs(i);
            if (i < N - 2){
                nums[Math.abs(i)] = - Math.abs(nums[Math.abs(i)]);
            }
            else {
                mark[N-Math.abs(i)] = true;
            }
        }
        int gap = (((1+N)*N)>>1) - sum;
        for (int i = 0; i < 3; i++) {
            if (!mark[i]){
                ans[0] = N-i;
                ans[1] = gap-ans[0];
                return ans;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>0){
                ans[0] = nums[i];
                ans[1] = gap - ans[0];
                return ans;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoDisappearedNumber().missingTwo(new int[]{2,3})));

    }
}
