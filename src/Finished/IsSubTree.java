package Finished;

public class IsSubTree {
    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了95.64%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了40.00%的用户
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode4 s, TreeNode4 t) {
        return PreBL(s,t);
    }

    private boolean PreBL(TreeNode4 s, TreeNode4 t) {
        if (s==null){
            return t==null?true:false;
        }
        if (s.val==t.val){
            if(judge(s,t)){
                return true;
            }
        }
        if (PreBL(s.left,t)) return true;
        return PreBL(s.right,t);

    }

    private boolean judge(TreeNode4 s, TreeNode4 t) {
        if (t == null ){
            return s==null?true:false;
        }
        if (s==null) return false;
        if (s.val!=t.val){
            return false;
        }
        System.out.println(s.val+" "+t.val);
        if (!judge(s.left,t.left)) return false;
        return judge(s.right,t.right);
    }

    public static void main(String[] args) {
        TreeNode4 s = new TreeNode4(3);
        TreeNode4 s1 = new TreeNode4(4);
        TreeNode4 s2 = new TreeNode4(5);
        TreeNode4 s3 = new TreeNode4(1);
        TreeNode4 s4 = new TreeNode4(2);
        TreeNode4 s5 = new TreeNode4(0);
        s.left = s1;
        s.right = s2;
        s1.left =s3;
        s1.right = s4;
        s4.left =s5;
        TreeNode4 t = new TreeNode4(4);
        TreeNode4 t1 = new TreeNode4(1);
        TreeNode4 t2 = new TreeNode4(2);
        t.left = t1;
        t.right = t2;
        IsSubTree isSubTree = new IsSubTree();
        System.out.println(isSubTree.isSubtree(s,t));
    }
}
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4(int x) { val = x; }
}