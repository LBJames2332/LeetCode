package Finished;

public class InsertSortOfLink {
    /**
     * 执行用时 :26 ms, 在所有 Java 提交中击败了34.18%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode prev_cur = null;
        ListNode next_cur;
        ListNode help;
        ListNode prev;
        ListNode head2 = head;
        while (cur!=null){
            //cur = cur.next;
            next_cur = cur.next;
            help = head2;
            prev = null;
            while (help!=cur){
                if (help.val>cur.val){
                    //找到位置
                    if (prev==null) head2 = cur;
                    if (prev != null){
                        prev.next = cur;
                    }
                    prev_cur.next = cur.next;
                    cur.next = help;
                    break;
                }
                prev = help;
                help = help.next;
            }
            if (help==cur) prev_cur = cur;
            cur = next_cur;

        }
        return head2;
    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        InsertSortOfLink insertSortOfLink = new InsertSortOfLink();
        insertSortOfLink.insertionSortList(node1);
    }
}
