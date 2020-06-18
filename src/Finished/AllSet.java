package Finished;

import java.util.LinkedList;
import java.util.List;

public class AllSet {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.17%的用户
     * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new LinkedList<>();

        process(nums,0,l);
        return ans;



    }

    private void process(int[] nums, int i, List<Integer> l) {
        if (i==nums.length) ans.add(l);
        else {
            List<Integer> l2 = new LinkedList<>();
            l2.addAll(l);
            process(nums,i+1,l);
            l2.add(nums[i]);
            process(nums,i+1,l2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllSet().subsets(new int[]{1,2,3}));
    }
}
