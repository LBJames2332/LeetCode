package Finished.Tree;

import Tools.Classes.TreeNode;

public class ReverseBT {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return test(root1,root2);
    }
    private boolean test(TreeNode node1,TreeNode node2){
        if(node1==null){
            return node2==null;
        }
        if(node2==null) return false;
        if (node1.val!=node2.val) return false;

        return (test(node1.left,node2.left)&&test(node1.right,node2.right))||
                (test(node1.left,node2.right)&&test(node1.right,node2.left));
    }
}
