package Finished.Powerful;

public class FindLossOne {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了7.83%的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        boolean biggestOne = false;
        for (int i:nums){
            int val = Math.abs(i);
            if (i==nums.length) biggestOne = true;
            else nums[val] = -nums[val];
        }
        if (!biggestOne) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindLossOne().missingNumber(new int[]{0,1,3}));
    }
}
