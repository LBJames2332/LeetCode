package Finished;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    /**
     * 执行用时 :55 ms, 在所有 Java 提交中击败了95.51%的用户
     * 内存消耗 :45.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param args
     */
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.numMatchingSubseq("abcde",new String[]{"a", "bb", "acd", "ace"}));
    }
    int ans = 0;
    public int numMatchingSubseq(String S, String[] words) {
        List<Node>[] dictionary = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            dictionary[i] = new ArrayList<Node>();
        for (String s:words){
            dictionary[s.charAt(0)-'a'].add(new Node(0,s));
        }
        for (char c:S.toCharArray()){
            //对于所有的迭代到以c为首字符的word
            List<Node> o = dictionary[c-'a'];
            dictionary[c - 'a'] =  new ArrayList<>();
            List<Node> n = new ArrayList<>();
            for (Node node: o){
                node.index++;
                if (node.index == node.word.length()) ans++;
                else{
                    dictionary[node.word.charAt(node.index)-'a'].add(node);
                }
            }
        }
        return ans;
    }
    class Node{
        int index;
        String word;

        public Node(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }
}
