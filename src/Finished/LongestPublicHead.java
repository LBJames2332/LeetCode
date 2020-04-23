package Finished;

public class LongestPublicHead {
    //最长公共前缀
    //https://leetcode-cn.com/problems/longest-common-prefix/
    //执行用时 :1 ms, 在所有 Java 提交中击败了80.61%的用户
    //内存消耗 :37.8 MB, 在所有 Java 提交中击败了18.34%的用户
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"","aaae23","aaae2t4"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        char c;
        int length = 0;
        if (strs[0].length()==0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length()==0) return "";
                if (strs[j].length()<i+1||strs[j].charAt(i)!=c) return strs[0].substring(0,length);
            }
            length++;
        }
        return strs[0].substring(0,length);
    }
}
