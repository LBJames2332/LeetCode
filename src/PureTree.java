import Tools.Classes.TreeNode;

public class PureTree {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了8.33%的用户
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        return contain(root)?root:null;
    }

    private boolean contain(TreeNode node) {
        if (node==null) return false;
        boolean l = contain(node.left);
        boolean r = contain(node.right);
        if (!l) node.left = null;
        if (!r) node.right = null;
        if (l||r||node.val==1) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        TreeNode node = new PureTree().pruneTree(node1);
        System.out.println(1);
    }
}
