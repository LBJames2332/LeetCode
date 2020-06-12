package Finished;

import java.util.*;

public class GameSolitaire {
    List<List<DictionaryTreeNode>> tree = new ArrayList<>();//字典树
    List<List<String>> ans = new ArrayList<>();

    /**
     * 执行用时 :1008 ms, 在所有 Java 提交中击败了7.95%的用户
     * 内存消耗 :44.1 MB, 在所有 Java 提交中击败了90.00%的用户
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dictionary = new HashSet<>();
        //Map<String,Integer> dic_level = new HashMap<>();
        for (String s:wordList){
            dictionary.add(s);
        }
        if (!dictionary.contains(endWord)) return ans;
        if (beginWord.length()!=endWord.length()) return ans;//长度不同是无论如何都变不过去的
        boolean direct = false;
        if (dictionary.contains(beginWord)) direct = true;


        List<DictionaryTreeNode> l1 = new ArrayList<>();
        l1.add(new DictionaryTreeNode(endWord));//第一层只有目标单词
        tree.add(l1);
        dictionary.remove(endWord);
        int size = dictionary.size();
        int level = 0;
        while (true){
            List <DictionaryTreeNode> lll = new ArrayList<>();
            for (String s:wordList){

                //字典中的每个可能都
                if (dictionary.contains(s)){
                    //已经添加到tree中的将不在集合里，后续不必讨论
                    //TODO optimize
                    int count = 0;
                    DictionaryTreeNode dictionaryTreeNode = new DictionaryTreeNode(s);
                    for (DictionaryTreeNode node:tree.get(level)){
                        //和前一层的逐个比较
                        //看看哪个（些）是它的父
                        if (compare(node.val.toCharArray(),s.toCharArray())==1){
                            //返回值为1意味着只有1位不同
                            //因为题目指出字典中无相同条目，所以返回值必不为0
                            node.childs.add(dictionaryTreeNode);
                            dictionaryTreeNode.Parents.add(node);
                            count=1;//有父的已经被添加到tree中，所以可以从set中remove掉
                        }
                    }
                    if (count==1) {
                        dictionary.remove(s);
                        lll.add(dictionaryTreeNode);
                    }
                }
            }
            if (size==dictionary.size())break;
            tree.add(lll);
            level++;
            if(dictionary.size()==0) break;
            size = dictionary.size();
        }
        //tree做好了
        //TODO Check size&tree
        if (direct){
            if (!dictionary.contains(beginWord)){
                //能够直接命中且该单词已经在树中了，我们就去找树即可
                for (int i = 0; i <= level; i++) {
                    for (DictionaryTreeNode node: tree.get(i)){
                        if (beginWord.equals(node.val)){
                            List<String> l = new ArrayList<>();
                            l.add(beginWord);
                            search(node,l);
                            return ans;
                        }
                    }
                }
            }
            else return ans;//如果begin直接命中且可以转化为end，则必然在树中，但是它不在树中，所以肯定无法转化了。

        }
        //否则只能找它能变成的最近的层次
        boolean returnnow = false;
        for (int i = 0; i <= level; i++) {
            for (DictionaryTreeNode node: tree.get(i)){
                int get = compare(beginWord.toCharArray(),node.val.toCharArray());
                if (get==1){
                    returnnow = true;
                    List<String> l = new ArrayList<>();
                    l.add(beginWord);
                    l.add(node.val);
                    search(node,l);
                }
            }
            if (returnnow) return ans;
        }
        return ans;
    }

    private void search(DictionaryTreeNode node,List<String> l) {
        if (node.Parents.size()==0){
            ans.add(l);
            return;
        }
        for (int i = 0; i < node.Parents.size()-1; i++) {
            List<String> ll =new ArrayList<>(l);
            ll.add(node.Parents.get(i).val);

            search(node.Parents.get(i),ll);
        }
        l.add(node.Parents.get(node.Parents.size()-1).val);
        search(node.Parents.get(node.Parents.size()-1),l);

    }

    class DictionaryTreeNode{
        String val;
        List<DictionaryTreeNode> Parents;
        List<DictionaryTreeNode> childs;

        public DictionaryTreeNode(String val) {
            this.val = val;
            Parents = new ArrayList<>();
            childs = new ArrayList<>();
        }
    }
    private int compare(char[] s1,char[] s2){
        if (s1.length!=s2.length)return 2;
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i]!=s2[i]){
                count++;
                if (count>1) return 2;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        GameSolitaire gameSolitaire = new GameSolitaire();
        List<String> input = new ArrayList<>();
        input.add("hot");
        input.add("dot");
        input.add("dog");
        input.add("lot");
        input.add("log");
        input.add("cog");
        System.out.println(gameSolitaire.findLadders("hit","cog",
                input));
    }
}
