package Finished;

import java.util.HashMap;
import java.util.Map;

public class PeaceSubsequence {
    /**
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
     * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     * 执行用时 :24 ms, 在所有 Java 提交中击败了67.25%的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer,Integer> e:map.entrySet()){
            if (map.containsKey(e.getKey()-1)){
                count = count < e.getValue()+map.get(e.getKey()-1)? (e.getValue()+map.get(e.getKey()-1)):count;
            }
        }
        return count;

    }
}
