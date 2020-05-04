package Finished;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticSlices {
    /**
     * 执行用时 :250 ms, 在所有 Java 提交中击败了24.68%的用户
     * 内存消耗 :86.6 MB, 在所有 Java 提交中击败了100.00%的用户
     *
     *
     * !!!!!!!!!!!!!!V[i].get(diff)表示以A[i]为结尾，diff为差值的若等差数列(长度 ≥ 2)!!!!!!!!!!!!!!!!
     * 统计等差子序列个数
     */
    int ans;
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer,Integer> [] V = new Map[A.length];
        long delta;
        int diff;
        int sum;
        int origin;
        for (int i = 0; i < A.length; i++) {
            V[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                delta = (long) A[i] -  (long)A[j];
                if (delta<Integer.MIN_VALUE||delta > Integer.MAX_VALUE){
                    continue;
                }
                diff = (int) delta;
                sum = V[j].getOrDefault(diff,0);//A[j]为底，diff为差的弱等差子序列的个数即为会变为等差子序列的个数
                origin = V[i].getOrDefault(diff,0);
                V[i].put(diff,sum+origin+1);//加的1是A[j],A[i]组成的弱等差数列
                ans +=sum;
            }
        }
        return ans;
    }
}
