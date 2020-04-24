package Finished;

public class LongestCommonSubsequence {
    /**
     * 最长公共子序列
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        return (a.length()>b.length())?a.length():b.length();
    }
}
