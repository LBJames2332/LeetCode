package Finished;

import java.util.ArrayList;
import java.util.List;

public class PostOrderMT {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    private List<Integer> ll = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        process(root);
        return ll;


    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了96.35%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了9.09%的用户
     * @param root
     */
    private void process(Node root){

        if (root==null) return;
        for (Node node:root.children) {
            process(node);
        }
        ll.add(root.val);
        return;
    }
}
