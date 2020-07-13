package Finished.LL;

import Tools.Classes.ListNode;

public class PalindromeLLO1 {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了48.02%的用户
     * 内存消耗：42.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node!=null){
            node = node.next;
            length++;
        }
        length = ((length+1)>>>1)-1;
        node = head;

        while (length>0){
            node = node.next;
            length--;
        }
        ListNode node2 = Reverse(node.next);
        node = head;
        while (node2!=null){
            if (node.val!=node2.val) return false;
            node = node.next;
            node2 = node2.next;
        }
        return true;
    }

    private ListNode Reverse(ListNode head) {
        if (head==null) return head;
        ListNode n;
        ListNode nn;
        ListNode p;
        p = head;
        n = head.next;
        if (n == null) return head;
        head.next = null;
        do {
            nn = n.next;
            n.next = p;
            p = n;
            n = nn;
        }while (nn!=null);
        return p;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(new PalindromeLLO1().isPalindrome(node));

    }
}
