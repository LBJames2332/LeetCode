package Finished.dataStructure;

import java.util.HashMap;
import java.util.Map;

public class SearchWord {
    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了6.21%的用户
     * 内存消耗：40.6 MB, 在所有 Java 提交中击败了14.29%的用户
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character,Integer>[] maps = new Map[words.length];
        int index = 0;
        for (String str:words){
            HashMap<Character,Integer> map = new HashMap<>();

            for (char c:str.toCharArray()){
//                if (c>='a'&&c<='z') map.put(c,map.getOrDefault(c,0)+1);
//                if (c>='A'&&c<='Z'){
//                    c = (char) (c + 'a'-'A');
                map.put(c,map.getOrDefault(c,0)+1);
//                }
            }
            maps[index++] = map;
        }
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        boolean seted = false;
        for (char c:licensePlate.toCharArray()){
            if (c>='a'&&c<='z') map.put(c,map.getOrDefault(c,0)+1);
            if (c>='A'&&c<='Z'){
                c = (char) (c + 'a'-'A');
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        for (int i = 0; i < maps.length; i++) {
            Map<Character, Integer> map1 = maps[i];
            boolean mark = false;
            for (Map.Entry<Character,Integer> entry:map.entrySet()){
                if (map1.getOrDefault(entry.getKey(),0)<entry.getValue()){
                    mark = true;
                    break;
                }
            }
            if (!mark) {
                if (!seted){
                    seted = true;
                    ans = i;
                }
                else {
                    if (words[ans].length()>words[i].length()) ans = i;
                }
            }
        }
        return words[ans];
    }

    public static void main(String[] args) {
        System.out.println(new SearchWord().shortestCompletingWord("1s3 PSt",new String[]{"step", "steps", "stripe", "stepple"}));
    }
}
