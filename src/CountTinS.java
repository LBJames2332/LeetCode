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

        /**
     * 暴力搜索法
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s.length()<t.length()) return count;

        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        for (int i = 0; i <= s.length()-t.length(); i++) {
            if (char_s[i]==char_t[0]){
                if (char_t.length==1) count++;
                else countStartFrom(char_s,char_t,i+1,1);
            }
        }
        return count;

    }
    public void countStartFrom(char[] s,char[] t,int s_s,int s_t){
        for (int i = s_s; i <= s.length-t.length+s_t; i++) {
            if (s[i]==t[s_t]){
                if (t.length==s_t+1) count++;
                else countStartFrom(s,t,i+1,s_t+1);
            }
        }
    }


}
