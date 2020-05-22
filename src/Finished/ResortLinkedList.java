package Finished;

public class ResortLinkedList {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了81.03%的用户
     * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了9.09%的用户
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        ListNode[] nodes = new ListNode[2];
        nodes[0] = head;//slow
        nodes[1] = nodes[0].next;
        ListNode help;
        while (nodes[1]!=null&&nodes[1].next!=null){
            nodes[0] = nodes[0].next;
            nodes[1] = nodes[1].next.next;
        }
        help = nodes[0].next;
        nodes[0].next = null;
        nodes[1] = reverseList(help);
        nodes[0]  = head;
        ListNode cur = nodes[0];
        nodes[0] = nodes[0].next;
        byte index = 1;
        while (nodes[index]!=null){
            cur.next = nodes[index];
            nodes[index] = nodes[index].next;
            index^=1;
            cur = cur.next;
        }
        if (nodes[0]!=null) cur.next = nodes[0];
        if (nodes[1]!=null) cur.next = nodes[1];

        return;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        ListNode prev = null;
        ListNode next;
        while (!(head==null)){

            next = head;

            head = head.next;
            next.next = prev;
            prev = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ResortLinkedList resortLinkedList = new ResortLinkedList();
        resortLinkedList.reorderList(node1);
    }
}
