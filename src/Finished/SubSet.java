package Finished;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSet {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
     * 执行用时 :2 ms, 在所有 Java 提交中击败了33.98%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.45%的用户
     * @param args
     */
    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3, 4});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        s.add(1);
        if (s.contains(1));
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
