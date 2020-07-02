package Finished.dataStructure;

/**
 * 执行用时：40 ms, 在所有 Java 提交中击败了95.85%的用户
 * 内存消耗：50.3 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Trie {
    TTNode root;
    class TTNode{
        TTNode[] chars = new TTNode[26];
        boolean isEnd;//设置为一个终点，判断search的时候用

    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TTNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] char_s = word.toCharArray();
        TTNode node = root;
        for (int i = 0; i < char_s.length; i++) {
            int help = char_s[i]-'a';
            if (node.chars[help]==null){
                //不包含
                node.chars[help] = new TTNode();
            }
            node = node.chars[help];
            if (i==char_s.length-1) node.isEnd = true;
        }
        System.out.println(111);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] char_s = word.toCharArray();
        TTNode node = root;
        for (int i = 0; i < char_s.length; i++) {
            int help = char_s[i]-'a';
            if (node.chars[help]==null){
                //不包含
                return false;
            }
            node = node.chars[help];
            if (i==char_s.length-1) {
                return node.isEnd;
            }

        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] char_s = prefix.toCharArray();
        TTNode node = root;
        for (int i = 0; i < char_s.length; i++) {
            int help = char_s[i]-'a';
            if (node.chars[help]==null){
                //不包含
                return false;
            }
            node = node.chars[help];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("aap"));
        System.out.println(1111);
    }

}
