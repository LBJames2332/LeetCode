package Finished;

import java.util.HashSet;
import java.util.Set;

public class LongestUnrepeatedSStr {
    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了68.61%的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] char_S = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int rindex = 0;
        int max = 0;
        int lindex = 0;
        Set<Character> sset;
        while (rindex<char_S.length){
            while (rindex<char_S.length && !set.contains(char_S[rindex])){
                set.add(char_S[rindex++]);
            }
            max = Math.max(max,set.size());
            set.remove(char_S[lindex++]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestUnrepeatedSStr().lengthOfLongestSubstring("abcabcbb"));
    }
}
