package Finished;

public class IsSubSequence {
    /**
     *执行用时 :14 ms, 在所有 Java 提交中击败了32.91%的用户
     * 内存消耗 :45.3 MB, 在所有 Java 提交中击败了100.00%
     * 的用户
     * @return
     */
    public static void main(String[] args) {
        System.out.println(isSubsequence("leetcode", "yyyyylyyyyyeyyyyyyyyyyyyeyyyyyyyyyyyyytyyyyyyycyyyyyyyoydyyyyeyyyyy"));
    }
    public static boolean isSubsequence(String s, String t) {
        /**
         * 动态规划直接版
         */
        if (s.length()>t.length()) return false;
        if (s.length()==0) return true;
        int[] count = new int[t.length()];
        if (s.charAt(0)==t.charAt(0)) count[0] = 1;
        for (int i = 1; i < count.length; i++) {
            if (t.charAt(i)==s.charAt(count[i-1])){
                count[i] = count[i-1]+1;
            }
            else count[i] = count[i-1];
            if (count[i] == s.length()) return true;
        }
        if (count[count.length-1]==s.length())return true;
        return false;

    }
}
