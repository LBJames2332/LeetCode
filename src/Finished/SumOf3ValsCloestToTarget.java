package Finished;

import java.util.Arrays;

public class SumOf3ValsCloestToTarget {
    int minimum_gap;

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了86.06%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了6.82%的用户
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        minimum_gap = nums[0] + nums[1] + nums[2] - target;//维护一个最小差值
        int real_target;
        Arrays.sort(nums);
        int left;
        int right;

        for (int i = 1; i < nums.length; i++) {//i-1的值为定下的那个值

            real_target = target - nums[i - 1];
            //if (real_target < 0) break;TODO 小加速
            left = i;
            right = nums.length - 1;
            while (left < right) {
                int gap = nums[left] + nums[right] - real_target;

                minimum_gap = Math.abs(minimum_gap) > Math.abs(gap) ? gap : minimum_gap;
                if (gap > 0) right--;
                else if (gap < 0) left++;
                else return target;
            }

        }
        return target + minimum_gap;
    }

    public static void main(String[] args) {
        System.out.println(new SumOf3ValsCloestToTarget().threeSumClosest(new int[]{0,0,0},1));
    }
}
