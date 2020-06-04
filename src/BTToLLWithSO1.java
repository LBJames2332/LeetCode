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

}
