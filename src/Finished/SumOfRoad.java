package Finished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfRoad {
    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在“根节点”到“叶子节点”的路径，这条路径上所有节点值相加等于目标和。
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
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的“路径”。
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

    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
     * 路径 “不需要从根节点开始，也不需要在叶子节点结束” ，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 链接：https://leetcode-cn.com/problems/path-sum-iii
     * @param root
     * @param sum
     * @return
     */
    int count = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public int pathSum3(TreeNode root, int sum) {
        if (root==null) return count;
        map.put(0,1);
        count += map.getOrDefault(root.val-sum,0);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        Search(root,root.val,sum);
        return count;
    }

    private void Search3(TreeNode root, int i, int sum) {

        if (root==null) return;


        if (root.left!=null) {
            count += map.getOrDefault(i+root.left.val-sum,0);
            map.put(i+root.left.val,map.getOrDefault(i+root.left.val,0)+1);
            Search(root.left,i+root.left.val,sum);
            map.put(i+root.left.val,map.get(i+root.left.val) - 1);
        }
        if (root.right!=null) {
            count += map.getOrDefault(i+root.right.val-sum,0);
            map.put(i+root.right.val,map.getOrDefault(i+root.right.val,0)+1);
            Search(root.right,i+root.right.val,sum);
            map.put(i+root.right.val,map.get(i+root.right.val) - 1);
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
