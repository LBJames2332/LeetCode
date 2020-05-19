package Finished;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FindTargetInClone {
    /**
     * 执行用时 :26 ms, 在所有 Java 提交中击败了5.48%的用户
     * 内存消耗 :47.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original==target) return cloned;
        TreeNode help = null;
        TreeNode help_clone = null;
        Queue<TreeNode> nodes = new LinkedBlockingQueue<>();
        Queue<TreeNode> nodes_clone = new LinkedBlockingQueue<>();
        nodes.add(original);
        nodes_clone.add(cloned);
        while (!nodes.isEmpty()){
            help = nodes.poll();
            help_clone = nodes_clone.poll();
            if (help.left!=null){
                if (help.left==target){
                    return help_clone.left;
                }
                nodes.add(help.left);
                nodes_clone.add(help_clone.left);
            }
            if (help.right!=null){
                if (help.right==target){
                    return help_clone.right;
                }
                nodes.add(help.right);
                nodes_clone.add(help_clone.right);
            }
        }
        return  null;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
