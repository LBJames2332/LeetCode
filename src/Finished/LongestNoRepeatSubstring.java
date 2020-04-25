package Finished;

import java.util.HashMap;
import java.util.Map;

public class LongestNoRepeatSubstring {
    /**
     * 执行用时 :249 ms, 在所有 Java 提交中击败了7.21%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了5.20%的用户
     * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] char_s = s.toCharArray();
        int maxlength = 0;
        int length;
        Map<Character,Integer> recordmap = new HashMap<>();
        for (int i = 0; i < s.length()-maxlength; i++) {
            length = 0;
            recordmap.clear();
            System.out.println(recordmap.size());
            for (int j = i; j < s.length(); j++) {
                //从i开始找最长的子串长度
                if (!recordmap.containsKey(char_s[j])){
                    recordmap.put(char_s[j],1);
                    length++;
                }
                else {
                    maxlength = (maxlength>length)?maxlength:length;
                    break;
                }
            }
            maxlength = (maxlength>length)?maxlength:length;
        }
        return maxlength;
    }
}
