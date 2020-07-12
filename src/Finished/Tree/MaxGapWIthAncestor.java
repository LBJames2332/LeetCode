package Finished.Tree;

import Tools.Classes.TreeNode;

public class MaxGapWIthAncestor {
    int max;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了50.00%的用户
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        //if(root.left!=null) max = Math.abs(root.val - root.left.val);
        //if(root.right!=null) max = Math.abs(root.val - root.right.val);
        diff(root.left,root.val,root.val);
        diff(root.right,root.val,root.val);
        return max;
    }

    private void diff(TreeNode node, int max_in_path,int min_in_path) {
        if (node==null) return;
        max = Math.max(Math.abs(min_in_path-node.val),Math.max(max,Math.abs(max_in_path - node.val)));
        diff(node.left,Math.max(max_in_path,node.val),Math.min(min_in_path,node.val));
        diff(node.right,Math.max(max_in_path,node.val),Math.min(min_in_path,node.val));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        node6.left = node9;
        System.out.println(new MaxGapWIthAncestor().maxAncestorDiff(node1));
    }
}
