package Finished;

public class LinkedListInBT {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return Search(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean Search(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return Search(head.next, root.left) || Search(head.next, root.right);
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1  =new ListNode(1);
        ListNode node2  =new ListNode(10);
        node1.next = node2;
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(9);
        t1.right = t2;
        t2.left = t3;
        t3.left = t5;
        t2.right = t4;
        System.out.println(new LinkedListInBT().isSubPath(node1,t1));
    }
}
