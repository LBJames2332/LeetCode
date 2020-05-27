package Finished;

public class OddEvenLinkedList {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39 MB, 在所有 Java 提交中击败了8.70%的用户
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode node_odd;
        ListNode node_even;
        ListNode node_odd_iter;
        ListNode node_even_iter;
        if (head==null||head.next==null) return head;
        node_odd = head;
        node_odd_iter = node_odd;
        node_even = node_odd.next;
        node_even_iter = node_even;

        while (true){
            if (node_even_iter.next==null){
                node_odd_iter.next=null;
                break;
            }
            node_odd_iter.next = node_even_iter.next;
            node_odd_iter = node_odd_iter.next;
            if (node_odd_iter.next==null) {
                node_even_iter.next=null;
                break;
            }
            node_even_iter.next = node_odd_iter.next;
            node_even_iter = node_even_iter.next;
        }


        node_odd_iter.next =node_even;
        return node_odd;

    }
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
