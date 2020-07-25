package Finished.dataStructure;

import java.util.*;

public class UsefulStr {
    /**
     * 执行用时：25 ms, 在所有 Java 提交中击败了12.13%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了25.00%的用户
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c:A[0].toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 1; i < A.length; i++) {
            Map<Character,Integer> mm = new HashMap<>();
            for (char c:A[i].toCharArray()){
                if (map.containsKey(c)) mm.put(c,mm.getOrDefault(c,0)+1);
            }
            Set<Character> keys = map.keySet();
            Iterator<Character> iterator = keys.iterator();
            while (iterator.hasNext()){
                Character next = iterator.next();
                if (mm.containsKey(next)) map.put(next,Math.min(map.get(next),mm.get(next)));
                else iterator.remove();
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            for (int i = 0; i < entry.getValue(); i++) {
                ans.add(entry.getKey()+"");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new UsefulStr().commonChars(new String[]{"cool","lock","cook"}));
    }
}