package Finished;

public class DelNode {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node==null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
