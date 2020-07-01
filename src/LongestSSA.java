public class LongestSSA {
    /**
     * 行用时：58 ms, 在所有 Java 提交中击败了54.26%的用户
     * 内存消耗：49 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] dp =new int[A.length][B.length];
        for (int i = 0; i < B.length; i++) {
            dp[0][i] = (A[0]==B[i])?1:0;
        }
        for (int i = 1; i < A.length; i++) {
            dp[i][0] = (A[i]==B[0])?1:0;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i]==B[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(dp[i][j],ans);
                }
                else dp[i][j] = 0;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new LongestSSA().findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
}
