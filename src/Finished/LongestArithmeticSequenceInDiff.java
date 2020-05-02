package Finished;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequenceInDiff {
    /**
     * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
     *
     */
    int ans = 1;
    public int longestSubsequence(int[] arr, int difference) {
        int length = 1;
        for (int i = 0; i < arr.length-1; i++) {
            length = SearchFrom(arr,difference,arr[i],i+1,length);
            ans = ans > length ? ans : length;
            length = 1;
        }
        return ans;
    }

    private int SearchFrom(int[] arr, int difference, int prev_val, int start,int length) {
        int prev_length = length;
        int return_val;
        for (int j = start; j < arr.length; j++) {
            if (arr[j] - prev_val == difference){
                return_val = SearchFrom(arr,difference,arr[j],j+1,length+1);
                prev_length = (prev_length>return_val)?prev_length:return_val;
            }
        }

        return prev_length;
    }

    public static void main(String[] args) {
        LongestArithmeticSequenceInDiff longestArithmeticSequenceInDiff = new LongestArithmeticSequenceInDiff();
        System.out.println(longestArithmeticSequenceInDiff.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }

    /**
     * 执行用时 :63 ms, 在所有 Java 提交中击败了35.69%的用户
     * 内存消耗 :59.2 MB, 在所有 Java 提交中击败了25.00%的用户
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence_map(int[] arr, int difference) {
        int length = 1;
        Map<Integer,Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!dp.containsKey(arr[i] - difference)){
                dp.put(arr[i],dp.get(arr[i] - difference)+1);
                length = (length> dp.get(arr[i]))?length: dp.get(arr[i]);
            }
            else dp.put(arr[i],1);
        }
        return length;
    }
}
