package Finished.DP;

public class WildcardMatch {
    /**
     * 执行用时：24 ms, 在所有 Java 提交中击败了64.51%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了46.43%的用户
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] char_s = s.toCharArray();
        char[] char_p = p.toCharArray();
        boolean[][] dp = new boolean[char_s.length+1][char_p.length+1];
        dp[0][0] = true;
        for (int i = 0; i < char_p.length; i++) {
            if (char_p[i]=='*') dp[0][i+1] = true;//前面的一连串*都可以匹配“”
            else break;//出现任何例外则中断匹配
        }
        for (int i = 0; i < char_s.length; i++) {
            for (int j = 0; j < char_p.length; j++) {
                if (char_s[i]==char_p[j]||char_p[j]=='?'){
                    //相等则显然是直接相等
                    dp[i+1][j+1] = dp[i][j];
                }
                else {
                    //此时讨论特殊情况
                    if (char_p[j]=='*'){
                        dp[i+1][j+1] = dp[i][j+1]|dp[i+1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatch().isMatch("cbccsa","c*a"));
    }
}
