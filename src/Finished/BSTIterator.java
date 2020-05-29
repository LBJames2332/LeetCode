package Finished;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BSTIterator {
    Queue<Integer> queue = new LinkedBlockingQueue<>();

    /**
     * 执行用时 :30 ms, 在所有 Java 提交中击败了24.51%的用户
     * 内存消耗 :45.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     */
    public BSTIterator(TreeNode root) {
        process(root);
    }

    private void process(TreeNode root) {
        if (root==null) return;
        process(root.left);
        queue.add(root.val);
        process(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (queue.size()>0) return true;
        else return false;
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
