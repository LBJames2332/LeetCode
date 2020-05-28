package Finished;

public class DivideLinkedList {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lesshead = null;
        ListNode orilesshead = null;
        ListNode morehead = null;
        ListNode orimorehead = null;

        while (head != null) {
            if (head.val < x) {
                if (lesshead == null) {
                    lesshead = head;
                    orilesshead = lesshead;
                } else {
                    lesshead.next = head;
                    lesshead = lesshead.next;
                }
            } else {
                if (morehead == null) {
                    morehead = head;
                    orimorehead = morehead;
                } else {
                    morehead.next = head;
                    morehead = morehead.next;
                }
            }
            head = head.next;
        }

        if (lesshead == null) return orimorehead;
        else if (morehead == null) return orilesshead;
        lesshead.next = orimorehead;
        morehead.next = null;
        return orilesshead;
    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        DivideLinkedList divideLinkedList = new DivideLinkedList();
        divideLinkedList.partition(node1,3);
    }
}
