package Finished;

import Tools.Classes.ListNode;

public class DelNodeEqualsVal {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode return_node = new ListNode(0);
        return_node.next = head;
        ListNode prev = return_node;
        ListNode curr = head;
        while (curr!=null&&curr.val!=val){
            prev = curr;
            curr = curr.next;
        }
        if (curr!=null) prev.next = curr.next;
        return return_node.next;
    }
}
