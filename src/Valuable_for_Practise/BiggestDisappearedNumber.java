package Valuable_for_Practise;

import java.util.Arrays;

public class BiggestDisappearedNumber {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了89.55%的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了8.33%的用户
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        boolean exist1 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                exist1 = true;
                continue;
            }
            if (nums[i] <= 0||nums[i] > nums.length) nums[i] = 1;
        }
        System.out.println(Arrays.toString(nums));
        if (!exist1) return 1;
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = 0 - Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return (i+1);
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        BiggestDisappearedNumber biggestDisappearedNumber = new BiggestDisappearedNumber();
        System.out.println(biggestDisappearedNumber.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
