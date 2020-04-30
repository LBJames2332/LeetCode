package Finished;

public class CountPalindromeSubstring {
    //统计回文子串的个数
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了96.99%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.55%的用户
     */
    int count = 0;

    public int countSubstrings(String s) {
        char[] char_s = s.toCharArray();
        for (int i = 0; i < char_s.length; i++) {
            countSubstringsCenterBy(char_s,i,i);
            countSubstringsCenterBy(char_s,i,i+1);
        }
        return count;
    }
    public void countSubstringsCenterBy(char[] char_s,int start,int end) {
        while (start >=0&&end<=char_s.length-1){
            if (char_s[start--]!=char_s[end++]) return;
            count++;
        }

    }
}
