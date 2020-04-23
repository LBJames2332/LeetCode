public class Merge2SortedLinks {
    /**合并两个有序链表
     * 执行用时 :1 ms, 在所有 Java 提交中击败了72.03%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了59.81%的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        if (l1.value <l2.value) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    class ListNode{
        int value;
        ListNode next;
    }
}
