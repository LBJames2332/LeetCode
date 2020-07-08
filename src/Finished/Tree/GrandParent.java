package Finished.Tree;

import Tools.Classes.TreeNode;

public class GrandParent {
    class Info{
        int father;
        int grandfather;

        public Info(int father, int grandfather) {
            this.father = father;
            this.grandfather = grandfather;
        }
    }
    int ans;
    public int sumEvenGrandparent(TreeNode root) {
        check(root,new Info(1,1));
        return ans;
    }

    private void check(TreeNode root, Info info) {
        if (root==null) return;
        if ((info.grandfather&1)==0){
            ans+=root.val;
        }
        Info info1 = new Info(root.val,info.father);
        check(root.left,info1);
        check(root.right,info1);
    }
}
