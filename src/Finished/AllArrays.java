package Finished;

import java.util.ArrayList;
import java.util.List;

public class AllArrays {
    /**
     * 全排列
     * 执行用时 :2 ms, 在所有 Java 提交中击败了80.18%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了7.32%的用户
     */

    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if (length == 0) return ans;
        boolean[] used = new boolean[length];
        List<Integer> l = new ArrayList<>();
        dfs(l,nums,used);
        return ans;
        
    }

    public static void dfs(List<Integer> l,int[] nums,boolean[] used) {
        if (l.size()==nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                used[i] = true;
                l.add(nums[i]);
                dfs(l,nums,used);
                used[i] = false;
                l.remove(l.size()-1);

            }
        }
        return;

    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        System.out.println(ans.toString());
    }
}
