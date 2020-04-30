package Finished;

public class CountTinS {
    /**
     * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
     * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     * 题目数据保证答案符合 32 位带符号整数范围。
     * 链接：https://leetcode-cn.com/problems/distinct-subsequences
     * @param s
     * @param t
     * @return
     */
    int count = 0;

    //    /**
//     * 暴力搜索法
//     * @param s
//     * @param t
//     * @return
//     */
//    public int numDistinct(String s, String t) {
//        if (s.length()<t.length()) return count;
//
//        char[] char_s = s.toCharArray();
//        char[] char_t = t.toCharArray();
//        for (int i = 0; i <= s.length()-t.length(); i++) {
//            if (char_s[i]==char_t[0]){
//                if (char_t.length==1) count++;
//                else countStartFrom(char_s,char_t,i+1,1);
//            }
//        }
//        return count;
//
//    }
//    public void countStartFrom(char[] s,char[] t,int s_s,int s_t){
//        for (int i = s_s; i <= s.length-t.length+s_t; i++) {
//            if (s[i]==t[s_t]){
//                if (t.length==s_t+1) count++;
//                else countStartFrom(s,t,i+1,s_t+1);
//            }
//        }
//    }

    /**
     * 二维数组dp法
     * dp[i][j]表示的是：s的前j个字符中包含t的前i个字符为子序列的个数
     * 有两种情况：1.若是s的第j个字符≠t的第i个字符那么s的第j个字符没有参与的价值，dp[i][j]就为dp[i][j-1]
     *           2.若是s的第j个字符＝t的第i个字符，那么有两种
     *                   a.s的前j-1个字符已经有dp[i][j-i]个以t的前i个字符为子序列的情况，则无需第j个字符的情况数为dp[i][j-1]
     *                   b.s的前j-1个字符有dp[i-1][j-1]和以t的前i-1个字符为子序列的情况，这些情况在s的第j个字符和t的第i个字符参与进来的情
     *                   况下都可以成为新的复合的情况
     * 执行用时 :5 ms, 在所有 Java 提交中击败了90.36%的用户
     * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了12.50%的用户
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s.length()<t.length()) return 0;
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i = 1; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (char_s[j]==char_t[i]){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
                else dp[i][j] = dp[i][j-1];
            }
        }
        return dp[char_t.length][char_s.length];

    }
}
