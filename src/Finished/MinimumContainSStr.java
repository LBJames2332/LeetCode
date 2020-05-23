package Finished;

import java.util.*;

public class MinimumContainSStr {
    int count;
    class Node{
        char val;
        int pos;

        public Node(char val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串
     * 执行用时 :19 ms, 在所有 Java 提交中击败了47.31%的用户
     * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length()>s.length()) return "";
        char[] char_S = s.toCharArray();
        char[] char_T = t.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < char_T.length; i++) {
            map.put(char_T[i],map.getOrDefault(char_T[i],0)+1);
        }
        count = char_T.length;
        int start;
        char help;
        List<Node> ll = new ArrayList<>();
        for (int i = 0; i < char_S.length; i++) {
            if (map.containsKey(char_S[i])){
                ll.add(new Node(char_S[i],i));
            }
        }
        if (ll.size()<count) return "";
        start = 0;
        map.put(ll.get(start).val,map.get(ll.get(start).val)-1);
        count--;
        if (count==0) return ll.get(start).val+"";//只有一个字符，直接return
        int index = 1;
        int min=0;
        boolean exist =false;
        int best_s=0;
        int best_e=char_S.length-1;
        while (index < ll.size()){
            help = ll.get(index).val;
            if (map.get(help)>0) count--;
            map.put(help,map.get(help)-1);//为负数则表示有盈余，可以直接支出

            if (count==0) {

                if (!exist||(min>ll.get(index).pos-ll.get(start).pos)){
                    exist = true;
                    min = ll.get(index).pos-ll.get(start).pos;
                    best_s = ll.get(start).pos;
                    best_e = ll.get(index).pos;
                }
                while (map.get(ll.get(start++).val) < 0) {
                    map.put(ll.get(start - 1).val,map.get(ll.get(start - 1).val)+1);
                    if (min>ll.get(index).pos-ll.get(start).pos){
                        min = ll.get(index).pos-ll.get(start).pos;
                        best_s = ll.get(start).pos;
                        best_e = ll.get(index).pos;
                    }
                }
                map.put(ll.get(start - 1).val,map.get(ll.get(start - 1).val)+1);
                count++;
            }
            index++;
        }
        if (!exist)  return "";
        else return s.substring(best_s,best_e+1);
    }
    public static void main(String[] args) {
        MinimumContainSStr minimumContainSStr = new MinimumContainSStr();
        System.out.println(minimumContainSStr.minWindow("ABDBEEFEAYTYAABAABC","EEA"));
    }
}
