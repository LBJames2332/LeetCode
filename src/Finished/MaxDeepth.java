package Finished;

public class MaxDeepth {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.75%的用户
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
