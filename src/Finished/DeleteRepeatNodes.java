package Finished;

import Tools.Classes.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteRepeatNodes {
    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了79.61%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head==null||head.next==null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode slow = head;
        set.add(slow.val);
        ListNode fast = head.next;
        while (fast!=null){
            if (set.contains(fast.val)){
                slow.next = fast.next;

            }
            else {
                set.add(fast.val);
                slow = slow.next;
            }
            fast = slow.next;
        }
        return head;
    }
}
