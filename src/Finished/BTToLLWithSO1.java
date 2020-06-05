package Finished;

import Tools.Classes.TreeNode;

public class BTToLLWithSO1 {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param root
     */
    public void flatten(TreeNode root) {
        Arrange(root);
    }

    private TreeNode Arrange(TreeNode curr) {
        if (curr==null) return curr;
        if (curr.left!=null){
            TreeNode right = curr.right;
            curr.right = Arrange(curr.left);
            curr.left = null;
            TreeNode c = curr.right;
            while (c.right!=null){
                c = c.right;
            }
            c.right = right;
            Arrange(right);

        }
        else Arrange(curr.right);
        return curr;
    }
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :38.9 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param root
     */
    private void flatten_O1(TreeNode root) {
        if (root==null) return;
        TreeNode rightest;
        while(root!=null) {

            if (root.left != null){
                //找其左子树的最有节点
                rightest = root.left;
                while (rightest.right != null) {
                    rightest = rightest.right;
                }
                rightest.right = root.right;
                root.right = root.left;
                root.left = null;

            }
            root = root.right;
        }
    }
}


