package Finished.DP;

public class InterleavedString {
    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了90.96%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了14.29%的用户
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] dp = new boolean[c1.length+1][c2.length+1];
        //dp[i][j]表示s1的前i个元素和s2的前j个元素是否能表示s3的前i+j个元素
        dp[0][0] = true;
        for (int i = 1; i <= c1.length; i++) {
            dp[i][0] = dp[i-1][0]&&c1[i-1]==c3[i-1];
        }
        for (int i = 1; i <= c2.length; i++) {
            dp[0][i] = dp[0][i-1]&&c2[i-1]==c3[i-1];
        }
        for (int i = 1; i <=c1.length ; i++) {
            for (int j = 1; j <= c2.length; j++) {
                dp[i][j] = (dp[i][j-1]&&c2[j-1]==c3[i+j-1])||(dp[i-1][j]&&c1[i-1]==c3[i+j-1]);
            }
        }
        return dp[c1.length][c2.length];

    }

    public static void main(String[] args) {
        System.out.println(new InterleavedString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
