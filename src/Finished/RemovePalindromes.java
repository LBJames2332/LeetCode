package Finished;
/**删除回文子序列
 * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */

public class RemovePalindromes {
    public int removePalindromeSub(String s) {
        if (s.length()==0) return 0;
        if(isPalindromeStr(s)) return 1;
        else return 2;
    }
    public static boolean isPalindromeStr(String s){
        char[] s_char = s.toCharArray();
        for (int i = 0; i < s_char.length; i++) {
            if (s_char[i]!=s_char[s_char.length-1-i]) return false;
        }
        return true;
    }
}
