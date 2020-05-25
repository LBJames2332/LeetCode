public class AddReversedLinks {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cur;//当前十进制值
        int more = 0;//进位
        ListNode head = new ListNode(0);
        ListNode return_val = head;
        while (l1!=null||l2!=null){
            cur = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+more;
            more = cur /10;
            cur = cur%10;
            head.next = new ListNode(cur);
            head = head.next;
            l1 = l1!=null?l1.next:l1;
            l2 = l2!=null?l2.next:l2;
        }
        if (more>0) head.next = new ListNode(more);
        return return_val.next;
    }
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
