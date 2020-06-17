package Finished;

import java.util.LinkedList;
import java.util.List;

public class partitionLetters {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :38.4 MB, 在所有 Java 提交中击败了25.00%的用户
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new LinkedList<>();
        char[] char_s = S.toCharArray();
        int[]rightest_pos = new int[26];
        for (int i = 0; i < char_s.length; i++) {
            rightest_pos[char_s[i]-'a'] = i;
        }
        int right = -1;
        int start;
        //int right_index = -1;
        do {
            start = right+1;
            right = rightest_pos[char_s[right+1] -'a'];
            for (int i = start; i < right; i++) {
                right = Math.max(right,rightest_pos[char_s[i] -'a']);
            }
            ans.add(right-start+1);
        }while (start<char_s.length);
        return ans;
    }
}
