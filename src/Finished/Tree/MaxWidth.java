package Finished.Tree;

import Tools.Classes.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MaxWidth {
    class N{
        TreeNode node;
        int pos;

        public N(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    int ans;

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了6.15%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        Queue<N> queue = new LinkedBlockingQueue<>();
        queue.add(new N(root,1));
        while (!queue.isEmpty()){
            int loop = queue.size();
            int s_pos = queue.peek().pos;
            while (loop>1){
                N N = queue.poll();
                TreeNode node = N.node;
                int pos = N.pos;
                if (node.left!=null) queue.add(new N(node.left,pos<<1));
                if (node.right!=null) queue.add(new N(node.right,(pos<<1)+1));
                loop--;
            }
            N N = queue.poll();
            TreeNode node = N.node;
            int pos = N.pos;
            if (node.left!=null) queue.add(new N(node.left,pos<<1));
            if (node.right!=null) queue.add(new N(node.right,(pos<<1)+1));
            ans = Math.max(ans,pos-s_pos);
        }
        return ans+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        node1.left = node2;
//        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.right = node6;
        System.out.println(new MaxWidth().widthOfBinaryTree(node1));
    }
}
