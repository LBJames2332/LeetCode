package Finished;

public class KReverse {
    ListNode node = null;
    ListNode HEAD_K;
    ListNode Mark_Head;
    ListNode prev = null;
    ListNode next = null;
    ListNode return_Node;
    ListNode help;
    ListNode help_head;

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了7.32%的用户
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return_Node = head;
        HEAD_K = head;
        node  = HEAD_K;
        for (int i = 0; i < k; i++) {
            if (node==null) return return_Node;
            node = node.next;
        }
        Mark_Head = HEAD_K;
        prev = node;
        for (int i = 0; i < k; i++) {
            next = HEAD_K.next;
            HEAD_K.next = prev;
            prev = HEAD_K;
            HEAD_K = next;
        }
        return_Node = prev;
        while (HEAD_K!=null){
            help_head = HEAD_K;
            help = ReverseFrom(k);
            if (help==null){
                return return_Node;
            }
            Mark_Head.next = help;

            Mark_Head = help_head;

        }
        return return_Node;



    }
    public ListNode ReverseFrom(int k){
        ListNode mark = node;
        for (int i = 0; i < k; i++) {
            if (node==null) {
                HEAD_K = null;
                return null;
            }
            node = node.next;
        }

        prev = node;
        for (int i = 0; i < k; i++) {
            next = HEAD_K.next;
            HEAD_K.next = prev;
            prev = HEAD_K;
            HEAD_K = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode ll =  new ListNode(1);
        ListNode l2 =  new ListNode(2);
        ListNode l3 =  new ListNode(3);
        ListNode l4 =  new ListNode(4);
        ListNode l5 =  new ListNode(5);
        ll.next  = l2;
        l2.next  = l3;
        l3.next  = l4;
        l4.next  = l5;
        KReverse kReverse = new KReverse();

        kReverse.print(kReverse.reverseKGroup(ll,5));
    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public void  print(ListNode node){
        while (node!=null) {

            System.out.println(node.val);
            node = node.next;
        }
    }
}
