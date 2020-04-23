import java.util.ArrayList;
import java.util.List;

public class SumOfPathInABinaryTree {
    /**输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 执行用时 :2 ms, 在所有 Java 提交中击败了60.48%的用户
     * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,null,7),new TreeNode(null,null,2),11),null,4)
                ,new TreeNode(new TreeNode(null,null,13),new TreeNode(new TreeNode(null,null,5),new TreeNode(null,null,1),4),8),5);
        System.out.println(pathSum(root,22));
    }
    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        if(root==null) return ans;
        path.add(root.val);
        if (root.left!=null) {
            path.add(root.left.val);
            Search(root.left,root.val+root.left.val,sum,path);
            path.remove(path.size()-1);
        }
        if (root.right!=null) {
            path.add(root.right.val);
            Search(root.right,root.val+root.right.val,sum,path);
            path.remove(path.size()-1);
        }
        if (root.left==null&&root.right==null){
            if(root.val==sum){
                path.add(root.val);
                ans.add(path);
            }
        }
        path.remove(path.size()-1);
        return ans;
    }
    public static void Search(TreeNode root, int sum_path, int sum, List<Integer> path){

        if (root.left==null&&root.right==null){
            if (sum == sum_path){
                ans.add(CloneArrayList(path));
            }
        }
        else {
            if (root.left!=null) {
                path.add(root.left.val);
                Search(root.left,sum_path+root.left.val,sum,path);
                path.remove(path.size()-1);
            }
            if (root.right!=null) {
                path.add(root.right.val);
                Search(root.right,sum_path+root.right.val,sum,path);
                path.remove(path.size()-1);
            }

        }

    }
    public static List<Integer> CloneArrayList(List<Integer> l){
        List<Integer> l2 = new ArrayList<>(l.size());
        for (int i = 0; i < l.size(); i++) {
            l2.add(l.get(i));
        }
        return l2;
    }
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(TreeNode l_child, TreeNode r_child, int value) {
            this.left = l_child;
            this.right = r_child;
            this.val = value;
        }
    }
}
