package Finished;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNums {
    /**
     * 执行用时 :10 ms, 在所有 Java 提交中击败了34.70%的用户
     * 内存消耗 :48.7 MB, 在所有 Java 提交中击败了45.83%的用户
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1] = - Math.abs(nums[Math.abs(nums[i])-1]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) ans.add(i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDisappearedNums findDisappearedNums = new FindDisappearedNums();
        System.out.println(findDisappearedNums.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
