package Finished;

import java.util.Arrays;

public class SumOfTheWidthOfAllSubSequences {
    /**
     * 给定一个整数数组 A ，考虑 A 的所有非空子序列。
     * 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。
     * 返回 A 的所有子序列的宽度之和。
     * 由于答案可能非常大，请返回答案模 10^9+7。
     * 链接：https://leetcode-cn.com/problems/sum-of-subsequence-widths
     * @param A
     * @return
     */
    public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007;
        long[] pow2 = new long[A.length];//存储2的i次方mod 1000000007的值
        pow2[0] = 1;
        for (int i = 1; i < A.length; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;
        Arrays.sort(A);
        long Sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                Sum= (long) ((Sum+(A[j]-A[i])*pow2[j-i-1])%1_000_000_007);
            }
        }
        return (int) Sum;


    }
}
