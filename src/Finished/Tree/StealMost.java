package Finished.Tree;

import Tools.Classes.TreeNode;

public class StealMost {
    /**
     * 执行用时：1294 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return Math.max(With(root),WithOut(root));
    }

    private int With(TreeNode node) {
        if (node==null) return 0;
        int l = WithOut(node.left);
        int r = WithOut(node.right);
        return l+r+node.val;
    }

    private int WithOut(TreeNode node) {
        if (node==null) return 0;
        int l = Math.max(With(node.left),WithOut(node.left));
        int r = Math.max(With(node.right),WithOut(node.right));
        return l+r;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(200);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(new StealMost().rob(node1));
    }
}
