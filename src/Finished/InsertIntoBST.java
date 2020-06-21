package Finished;

import Tools.Classes.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root,val);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了14.29%的用户
     * @param node
     * @param val
     * @return
     */
    private TreeNode insert(TreeNode node, int val) {
        if (node==null) return new TreeNode(val);
        if (node.val>val) node.left = insert(node.left,val);
        else node.right = insert(node.right,val);
        return node;
    }
}
