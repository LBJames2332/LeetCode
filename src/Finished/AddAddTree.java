package Finished;

public class AddAddTree {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {

        Get(root);
        return root;
    }

    private int Get_l(int val, TreeNode left) {
        if (left==null) return val;
        left.val += Get_l(val,left.right);
        return Get_l(left.val,left.left);
    }

    private int Get(TreeNode root) {
        if (root==null) return 0;
        root.val += Get(root.right);
        return Get_l(root.val,root.left);
    }

    static  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(5);
        TreeNode root7 = new TreeNode(6);
        TreeNode root8 = new TreeNode(7);
        TreeNode root9 = new TreeNode(8);
        root2.left = root1;
        root2.right = root3;
        root3.right = root4;
        root5.left = root2;
        root5.right = root7;

        root7.left = root6;
        root7.right = root8;
        root8.right = root9;
        AddAddTree addAddTree= new AddAddTree();
        System.out.println(addAddTree.convertBST(root5).val);
    }
}
