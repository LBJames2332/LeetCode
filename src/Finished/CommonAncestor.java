package Finished;

public class CommonAncestor {
    int val = 0;
    int val_1;
    int val_2;
    TreeNode Ancestor;

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了99.87%的用户
     * 内存消耗 :42 MB, 在所有 Java 提交中击败了5.71%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        val_1 = p.val;
        val_2 = q.val;
        if (root.val==val_1||root.val==val_2) return root;
        Search(root);
        return Ancestor;
    }

    private int Search(TreeNode root) {

        if (root==null) return 0;
        int val = 0;
        if (root.val==val_1){
            val+=1;
        }
        else if (root.val==val_2) val+=2;
        val|=Search(root.left);
        if (Ancestor!=null) return val;
        if (val==3) {
            Ancestor = root;
            return val;
        }
        val|=Search(root.right);
        if (Ancestor!=null) return val;
        if (val==3) {
            Ancestor = root;
        }

        return val;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        CommonAncestor commonAncestor = new CommonAncestor();
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(0);
        TreeNode root6 = new TreeNode(8);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(4);
        root.left =root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root4.left = root7;
        root4.right = root8;
        root2.left = root5;
        root2.right = root6;
        System.out.println(commonAncestor.lowestCommonAncestor(root,root1,root6).val);
    }
}
