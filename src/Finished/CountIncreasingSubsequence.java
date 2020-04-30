package Finished;

import java.util.*;

/**
 * 找出全部的不重复的递增子序列
 * 执行用时 :9 ms, 在所有 Java 提交中击败了77.81%的用户
 * 内存消耗 :45.8 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class CountIncreasingSubsequence {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<Integer> used_nums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used_nums.contains(nums[i])){
                used_nums.add(nums[i]);
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                SearchFrom(nums,i+1,l);
                l.remove(l.size()-1);
            }

        }
        return ans;
    }
    public void SearchFrom(int[] nums,int start,List<Integer> l) {
        Set<Integer> used_nums = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (nums[i] >= l.get(l.size()-1)){
                if (!used_nums.contains(nums[i])){
                    used_nums.add(nums[i]);
                    l.add(nums[i]);
                    ans.add(cloneList(l));
                    SearchFrom(nums,i+1,l);
                    l.remove(l.size()-1);
                }
            }
        }
    }
    public List<Integer> cloneList(List<Integer> l_s){
        List<Integer> l_to = new ArrayList<>(l_s.size());
        for (int i = 0; i < l_s.size(); i++) {
            l_to.add(l_s.get(i));
        }
        return l_to;
    }
}
