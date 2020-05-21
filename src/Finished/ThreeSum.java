package Finished;

import java.util.*;

public class ThreeSum {

    /**
     * 执行用时 :27 ms, 在所有 Java 提交中击败了56.16%的用户
     * 内存消耗 :43.9 MB, 在所有 Java 提交中击败了98.11%的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        int left;
        int right;
        int sum;
        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;//试想一下，要是nums[i]==1的时候有一些组合，
                                                         // 那么之后i后移到==1的位置的所有可能性都在之前囊括了
            left = i+1;
            right = nums.length-1;
            if (nums[i]>0) break;
            while (left < right){
                sum = nums[i]+nums[left]+nums[right];
                if (sum==0) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (nums[left]==nums[++left]&&left<right);//剪枝
                    while (nums[right]==nums[--right]&&left<right);//剪枝
                }
                else if (sum>0){
                    while (nums[right]==nums[--right]&&left<right);//剪枝
                }
                else {
                    while (nums[left]==nums[++left]&&left<right);//剪枝
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    class ListSet extends ArrayList{
        @Override
        public boolean add(Object o) {
            return super.add(o);
        }
    }

}
