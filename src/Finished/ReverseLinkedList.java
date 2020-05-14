package Finished;

public class ReverseLinkedList {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 39.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        ListNode prev = null;
        ListNode next = null;
        while (!(head==null)){

            next = head;

            head = head.next;
            next.next = prev;
            prev = next;
        }
        return prev;
    }
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
