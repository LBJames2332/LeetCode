package Finished;

public class CircleLinkedList2 {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了7.14%的用户
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) return null;
        ListNode slow = head;//慢指针已经走了1步
        ListNode fast = head.next;//快指针已经走了两步
        while (slow!=fast){
            if (fast==null||fast.next==null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        fast = head;
        while (slow!=head){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        CircleLinkedList2 circleLinkedList2  =  new CircleLinkedList2();
        circleLinkedList2.detectCycle(node);
    }
    static  class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
