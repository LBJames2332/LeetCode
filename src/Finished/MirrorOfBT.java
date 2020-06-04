package Finished;

import Tools.Classes.TreeNode;

public class MirrorOfBT {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        Reverse(root);
        return root;
    }

    private void Reverse(TreeNode root) {
        if (root==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Reverse(root.left);
        Reverse(root.right);

    }
}
