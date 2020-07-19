package Finished;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountFewer {
    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了75.72%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy_nums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int index = 0;
        int curr = index;
        Map<Integer,Integer> map = new HashMap<>();
        while (index<nums.length){
            while (curr<nums.length&&nums[curr]==nums[index]){
                curr++;
            }
            map.put(nums[index],index);
            index = curr;
        }

        for (int i = 0; i < nums.length; i++) {
            copy_nums[i] = map.get(copy_nums[i]);
        }
        return copy_nums;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountFewer().smallerNumbersThanCurrent(new int[]{7,7,7,7})));
    }
}
