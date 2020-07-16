package Finished.dataStructure;

import java.util.HashMap;
import java.util.Map;

public class NumOfGoodPairs {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了86.13%的用户
     * 内存消耗：37.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max = 0;
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        if (max<=1) return 0;
        int dp[] = new int[max+1];
        dp[2] = 1;
        for (int i = 3; i <= max; i++) {
            dp[i] = (i*(i-1))>>>1;
        }
        max = 0;
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            max += dp[entry.getValue()];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new NumOfGoodPairs().numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}
