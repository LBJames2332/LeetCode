package Finished;

import java.util.Stack;

public class MirrorBinaryTree {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了33.97%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    Stack<TreeNode4> stack_tree = new Stack<>();
    public boolean isSymmetric(TreeNode4 root) {
        if (root.right!=null&&root.left!=null){
            if (root.right.val==root.left.val){
                stack_tree.add(root.left);
                stack_tree.add(root.right);
                return Loop_Judge();
            }
        }
        else {
            if (!(root.right==null&&root.left==null)){
                return false;
            }
        }
        return true;
    }
    private boolean Loop_Judge() {
        TreeNode4 node1;
        TreeNode4 node2;
        while (!stack_tree.empty()){
            node1 = stack_tree.pop();
            node2 = stack_tree.pop();
            if (node1.left!=null&&node2.right!=null){
                if (node1.left.val==node2.right.val){
                    stack_tree.add(node1.left);
                    stack_tree.add(node2.right);
                }
                else return false;
            }
            else {
                if (!(node1.left==null&&node2.right==null)){
                    return false;
                }
            }
            if (node1.right!=null&&node2.left!=null){
                if (node1.right.val==node2.left.val){
                    stack_tree.add(node1.right);
                    stack_tree.add(node2.left);
                }
                else return false;
            }
            else {
                if (!(node1.right==null&&node2.left==null)){
                    return false;
                }
            }
        }
        return true;
    }
}
class TreeNode2 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode2(int x) { val = x; }
}
