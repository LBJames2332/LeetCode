package Finished;

public class BalanceTree {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getInfo(root).isBalanced;
    }
    private  Info getInfo(TreeNode node){
        if (node==null)  return new Info(0,true);
        Info infol = getInfo(node.left);
        if (!infol.isBalanced) return new Info(0,false);
        Info infor = getInfo(node.right);
        if (!infor.isBalanced||Math.abs(infol.height-infor.height)>1) return new Info(0,false);
        else return new Info(Math.max(infol.height,infor.height)+1,true);
    }
    class Info{
        int height;
        boolean isBalanced;

        public Info() {
        }

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
