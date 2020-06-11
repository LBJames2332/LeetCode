package Finished;

import Tools.Classes.ListNode;

public class SplitLL {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了5.55%的用户
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode return_val = new ListNode(0);
        ListNode help = head;
        ListNode less_tail = null;
        ListNode less_head = null;
        ListNode more_head = null;
        ListNode more_tail = null;
        ListNode prev;
        boolean mark_less =false;
        boolean mark_more =false;
        while (help!=null) {
            if (help.val < x) {
                if (!mark_less) {
                    mark_less = true;

                    less_head = help;
                }
                less_tail = help;
            } else {
                if (!mark_more) {
                    mark_more = true;
                    more_head = help;

                }
                more_tail = help;
            }
            if(mark_less&&mark_more)break;
            help = help.next;
        }
        if (!(mark_less&&mark_more)) return head;
        return_val.next = less_head;
        if (head==more_head){
            //从小往后把大的都接到more_tail后面，最后把morehead接到less_tail后面
            more_tail.next = null;
            prev = less_tail;
            head = less_tail.next;
            while (head!=null){
                if (head.val>=x){
                    prev.next = head.next;
                    more_tail.next = head;
                    head.next = less_head;
                    head = prev.next;
                    more_tail = more_tail.next;
                    more_tail.next = null;
                }
                else {
                    less_tail.next = head;
                    prev = head;
                    less_tail = head;
                    head = head.next;
                }
            }
        }
        else {
            //从大往后把小的都接到more_tail后面，最后把morehead接到less_tail后面
            less_tail.next = null;
            prev = more_tail;
            head = more_tail.next;
            while (head!=null){
                if (head.val < x){
                    prev.next = head.next;
                    less_tail.next = head;
                    head.next = more_head;
                    head = prev.next;
                    less_tail = less_tail.next;
                    less_tail.next = null;
                }
                else {
                    more_tail.next = head;
                    more_tail = head;
                    prev = head;
                    head = head.next;
                }
            }
        }
        less_tail.next = more_head;
        return return_val.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        new SplitLL().partition(node1,3);
    }
}
