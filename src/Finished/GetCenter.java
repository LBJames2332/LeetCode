package Finished;

import Tools.Classes.ListNode;

public class GetCenter {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast==null) return slow;
        else return slow.next;
    }
}
