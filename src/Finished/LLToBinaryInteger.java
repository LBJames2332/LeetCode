package Finished;

import Tools.Classes.ListNode;

public class LLToBinaryInteger {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了5.00%的用户
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head!=null){
            ans =(ans<<1) | head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new LLToBinaryInteger().getDecimalValue(node));
    }
}
