package Finished;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq_2dp(String s) {
        int len = s.length();
        char[] s_char = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0 ; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if (s_char[i]==s_char[j])dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = (dp[i + 1][j] > dp[i][j - 1])?dp[i + 1][j]:dp[i][j - 1];
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {

        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq_2dp("bbbab"));
    }

}
