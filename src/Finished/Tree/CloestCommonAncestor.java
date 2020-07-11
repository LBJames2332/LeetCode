package Finished.Tree;

import Tools.Classes.TreeNode;

public class CloestCommonAncestor {
    TreeNode ans = null;

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了41.32%的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了6.06%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        RelationWithPQ(root,p,q);
        return ans;
    }

    private byte RelationWithPQ(TreeNode node, TreeNode p, TreeNode q) {
        if (node==null) return 0;
        if (node==p) {
            byte return_val = (byte) (RelationWithPQ(p.left,p,q)|RelationWithPQ(p.right,p,q));
            if (return_val==2){
                if (ans==null){
                    ans = node;
                }
                return 3;
            }
            return 1;
        }
        if (node==q) {
            byte return_val = (byte) (RelationWithPQ(p.left,p,q)|RelationWithPQ(p.right,p,q));
            if (return_val==1){
                if (ans==null){
                    ans = node;
                }
                return 3;
            }
            return 2;
        }
        byte return_val = (byte) (RelationWithPQ(p.left,p,q)|RelationWithPQ(p.right,p,q));
        if (return_val==3){
            if (ans==null){
                ans = node;
            }
        }
        return return_val;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(5);
    }
}
