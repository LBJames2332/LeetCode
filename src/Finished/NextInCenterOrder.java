package Finished;

public class NextInCenterOrder {
    byte find = 0;

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return centerOrder(root,p);
    }

    private TreeNode centerOrder(TreeNode root, TreeNode p) {
        if (root==null) return null;
        TreeNode node = centerOrder(root.left,p);
        if ((find&3)==3) return node;
        if ((find&1)==1) {
            find|=2;
            return root;
        }
        if (root==p) find|=1;
        return centerOrder(root.right,p);
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
