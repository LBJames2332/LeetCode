package Finished;

import java.util.ArrayList;
import java.util.List;

public class SumOfRoad {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了6.52%的用户
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        return Search(root,root.val,sum);
    }

    private boolean Search(TreeNode root, int i, int sum) {
        if (root.left==null&&root.right==null){//是一个叶子节点
            if (i==sum) return true;
            return false;
        }
        else {
            if (root.left!=null) {
                if (root.right==null) return Search(root.left,i+root.left.val,sum);
                else if (Search(root.left,i+root.left.val,sum)) return true;
            }
            return  Search(root.right,i+root.right.val,sum);
        }
    }
    List<List<Integer>> ans =new ArrayList<>();
    ArrayList<Integer> ll = new ArrayList<>();

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了5.26%的用户
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null) return ans;

        Search2(root,root.val,sum);
        return ans;
    }
    private void Search2(TreeNode root, int i, int sum) {
        if (root.left==null&&root.right==null){//是一个叶子节点
            if (i==sum) {
                List<Integer> l2 = (ArrayList<Integer>) ll.clone();;
                ans.add(l2);
            }
            return;
        }
        else {
            if (root.left!=null) {
                ll.add(root.left.val);
                Search(root.left,i+root.left.val,sum);
                ll.remove(ll.size()-1);
            }
            if (root.right!=null) {
                ll.add(root.right.val);
                Search(root.right,i+root.right.val,sum);
                ll.remove(ll.size()-1);
            }
        }
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
