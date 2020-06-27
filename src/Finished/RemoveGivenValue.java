package Finished;

import java.util.Arrays;

public class RemoveGivenValue {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了5.68%的用户
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int size = 0;
        for (int v:nums){
            if (v!=val) nums[size++] = v;
        }
        System.out.println(Arrays.toString(nums));
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveGivenValue().removeElement(new int[]{1,2,2,3,3,2,1,1,3},2));
    }
}
