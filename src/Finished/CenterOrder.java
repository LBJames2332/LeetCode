package Finished;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CenterOrder {
    Stack<TreeNode> stack = new Stack<>();//自己压栈模拟递归
    List<Integer> ans = new ArrayList<>();

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了50.75%的用户
     * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.79%的用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)  return ans;
        TreeNode help;
        TreeNode prev=root;
        stack.add(root);
        do{
            help = stack.peek();
            if (prev!=help.left&&prev!=help.right){//若是它的左或右，则说明没必要向左走了
                if(help.left!=null){
                    help = help.left;
                    stack.add(help);
                }
                else {
                    prev = help;
                    ans.add(help.val);
                    System.out.println(help.val);

                    if (help.right!=null){
                        help = help.right;
                        stack.add(help);
                        prev = help;
                    }
                    else stack.pop();
                }
                continue;
            }
            if (prev==help.left){
                prev = help;
                ans.add(help.val);
                System.out.println(help.val);
                if (help.right!=null){
                    help = help.right;
                    stack.add(help);

                    prev = help;
                }
                else stack.pop();
                continue;
            }
            if (prev==help.right){
                prev = help;
                stack.pop();
            }
        }while (!stack.empty());
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        /**TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.right = node1;
        node1.left = node2;*/
        CenterOrder centerOrder = new CenterOrder();
        centerOrder.inorderTraversal(node);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
