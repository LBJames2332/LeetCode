package Finished;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了73.66%的用户
     * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] char_s = s.toCharArray();
        for (char c:char_s){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = s.length()%2;
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if ((entry.getValue()%2)==1){
                count--;
                if (count < 0) return false;
            }
        }
        return true;
    }
}
