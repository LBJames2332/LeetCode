package Finished;

public class PalindromeNumber {
    /**
     * 执行用时 :19 ms, 在所有 Java 提交中击败了10.00%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了5.14%的用户
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s_x = x + "";
        for (int i = 0;i < s_x.length()/2;i++){
            if (s_x.charAt(i)!=s_x.charAt(s_x.length()-i-1)) return false;
        }
        return true;
    }
}
