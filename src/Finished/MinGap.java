package Finished;

public class MinGap {
    public int smallestRangeI(int[] A, int K) {
        /**
         * 执行用时 :3 ms, 在所有 Java 提交中击败了72.25%的用户
         * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了50.00%的用户
         */
        if (A.length<2) return 0;
        int min = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(A[i],min);
            max = Math.max(A[i],max);
        }
        if (max - min <= (K<<1)) return 0;
        return max-min-(K<<1);
    }
}
