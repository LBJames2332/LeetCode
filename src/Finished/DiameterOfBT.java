package Finished;

import Tools.Classes.TreeNode;

public class DiameterOfBT {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了26.44%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了5.26%的用户
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        Info info1 = height(root.left);
        Info info2 = height(root.right);
        return Math.max(Math.max(info1.rootlength,info2.rootlength),info1.height+info2.height+1);
    }
    private Info height(TreeNode root){
        if (root==null) return new Info(0,0);
        Info info1 = height(root.left);
        Info info2 = height(root.right);
        return new Info(Math.max(info1.height,info2.height)+1
                ,Math.max(Math.max(info1.rootlength,info2.rootlength),info1.height+info2.height+1));
    }
    class Info{
        int height;
        int rootlength;

        public Info(int height, int rootlength) {
            this.height = height;
            this.rootlength = rootlength;
        }
    }
}
