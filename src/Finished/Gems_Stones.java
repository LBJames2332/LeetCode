package Finished;

import java.util.HashMap;
import java.util.Map;

public class Gems_Stones {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了52.98%的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了9.09%的用户
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < j.length; i++) {
            map.put(j[i],1);
        }
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (map.containsKey(s[i])) count++;
        }
        return count;
    }
}
