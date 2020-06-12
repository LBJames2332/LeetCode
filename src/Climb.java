public class Climb {
    /**
     * 执行用时:0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗:36.4 MB, 在所有 Java 提交中击败了5.66%的用户
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<2) return 1;
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i-1]+ans[i-2];
        }
        return ans[n];
    }
}
