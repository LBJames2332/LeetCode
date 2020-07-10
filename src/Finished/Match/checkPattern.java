package Finished.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class checkPattern {
    class Node{
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (index != node.index) return false;
            return count == node.count;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + count;
            return result;
        }
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了32.29%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        List<Node> l_p = Analysis(pattern);
        for (String s:words){
            if (checkEqual(l_p,Analysis(s))){
                ans.add(s);
            }
        }
        return ans;
    }
    public boolean checkEqual(List<Node> r1,List<Node> r2){
        if (r1==null&&r2==null) return true;
        if (r1==null||r2==null) return false;
        if (r1.size()!=r2.size()) return false;
        for (int i = 0; i < r1.size(); i++) {
            if (!r1.get(i).equals(r2.get(i))) return false;
        }
        return true;
    }
    private List<Node> Analysis(String s) {
        List<Node> re = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();//index,count
        int index = 0;
        char[] char_s = s.toCharArray();
        for (int i = 0; i < char_s.length; i++) {
            char c = char_s[i++];
            int c_index;
            if (map.containsKey(c)) c_index = map.get(c);
            else {
                c_index = index++;
                map.put(c,c_index);
            }
            Node node = new Node(c_index,1);
            if (i==char_s.length){
                re.add(node);
                return re;
            }
            c = char_s[i];
            while (i < char_s.length&&map.containsKey(c)&&map.get(c)==c_index){
                node.count++;
                i++;
                if (i==char_s.length){
                    re.add(node);
                    return re;
                }
                c = char_s[i];
            }
            re.add(node);
            i--;

        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(new checkPattern().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));

    }
}
