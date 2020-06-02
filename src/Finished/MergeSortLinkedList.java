package Finished;

import Tools.Classes.ListNode;

public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        return MergeSort(head);
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了99.26%的用户
     * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了5.88%的用户
     * @param head
     * @return
     */
    public ListNode MergeSort(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        head = MergeSort(head);
        fast = MergeSort(fast);
        ListNode retur_node = new ListNode(0);
        slow = retur_node;
        while (head!=null&&fast!=null){
            if (head.val > fast.val){
                retur_node.next = fast;
                retur_node = retur_node.next;
                fast = fast.next;
            }
            else {
                retur_node.next = head;
                retur_node = retur_node.next;
                head = head.next;
            }
        }
        if (head!=null){
            retur_node.next = head;
        }
        else retur_node.next = fast;
        return slow.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(-2);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
        mergeSortLinkedList.MergeSort(node1);
    }
}
