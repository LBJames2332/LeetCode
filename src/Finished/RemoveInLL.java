package Finished;

import Tools.Classes.ListNode;

public class RemoveInLL {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.87%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode return_before = new ListNode(1);
        return_before.next = head;
        ListNode prev = return_before;
        while (head!=null){
            if (head.val==val){
                prev.next = head.next;
                head = prev.next;
            }
            else {
                prev = head;
                head = head.next;
            }
        }
        return return_before.next;
    }
}
