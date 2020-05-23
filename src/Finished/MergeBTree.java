package Finished;

public class MergeBTree {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了91.18%的用户
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root1 = t1;
        TreeNode root2 = t2;
        t1 = doSth(t1,t2);
        return t1;
    }
    public TreeNode doSth(TreeNode t1, TreeNode t2){
        if (t1==null||t2==null) {
            if (t1==null) return t2;
        }
        else {
            t1.val = t1.val+ t2.val;
            t1.left = doSth(t1.left,t2.left);
            t1.right = doSth(t1.right,t2.right);
        }
        return t1;

    }
    public int getMethod(TreeNode t1, TreeNode t2){
        if (t1==null||t2==null) return 0;
        return 1;
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
