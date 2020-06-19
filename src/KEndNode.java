import Tools.Classes.ListNode;

public class KEndNode {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node==null) return null;
            node = node.next;
        }
        while (node!=null){
            head = head.next;
            node = node.next;
        }
        return head;

    }
}
