package Finished.Tree;

import Tools.Classes.TreeNode;

public class CheckValidBST {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return check(root).isValid;
    }

    private Info check(TreeNode node) {
        if (node.left==null){
            if (node.right==null) return new Info(node.val,node.val,true);
            if (node.val < node.right.val){
                Info info = check(node.right);
                if (!info.isValid||node.val>=info.min) return new Info(0,0,false);
                return new Info(node.val,info.max,true);
            }
            else return new Info(0,0,false);//返回false时max和min就不重要了
        }
        if (node.right==null){
            if (node.val > node.left.val){
                Info info = check(node.left);
                if (!info.isValid||node.val<=info.max) return new Info(0,0,false);
                return new Info(info.min,node.val,true);
            }
            else return new Info(0,0,false);//返回false时max和min就不重要了
        }
        if (node.val > node.left.val&&node.val < node.right.val){
            Info info_l = check(node.left);
            if (!info_l.isValid||node.val<=info_l.max) return new Info(0,0,false);
            Info info_r = check(node.right);
            if (!info_r.isValid||node.val>=info_r.min) return new Info(0,0,false);
            return new Info(info_l.min,info_r.max,true);
        }
        else return new Info(0,0,false);//返回false时max和min就不重要了
    }
    class Info{
        int max;
        int min;
        boolean isValid;

        public Info(int min, int max, boolean isValid) {
            this.max = max;
            this.min = min;
            this.isValid = isValid;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(20);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(new CheckValidBST().isValidBST(treeNode));
    }
}
