package Finished.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LPathInTraingle {
    int dp[];

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了73.68%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了8.70%的用户
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i > -1 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        List<List<Integer>> ll = new ArrayList<>();
        ll.add(l1);
        ll.add(l2);
        ll.add(l3);
        ll.add(l4);
        System.out.println(new LPathInTraingle().minimumTotal(ll));

    }
}
