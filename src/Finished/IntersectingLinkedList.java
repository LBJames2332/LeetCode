package Finished;

public class IntersectingLinkedList {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.97%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了71.43%的用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_a = 0;
        int len_b = 0;
        ListNode roota = headA;
        ListNode rootb = headB;
        while (roota!=null){
            len_a++;
            roota = roota.next;
        }
        while (rootb!=null){
            len_b++;
            rootb = rootb.next;
        }
        roota = headA;
        rootb = headB;
        if (len_a > len_b){
            for (int i = 0; i < len_a-len_b; i++) roota = roota.next;
            len_a = len_b;
        }
        if (len_a < len_b){
            for (int i = 0; i < len_b-len_a; i++) rootb = rootb.next;
            len_b = len_a;
        }

        while (len_a>0){
            if (roota==rootb) return roota;
            else {
                roota = roota.next;
                rootb = rootb.next;
                len_a--;
                len_b--;
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode root1 = new ListNode(9);
        ListNode root2 = new ListNode(1);
        ListNode root3 = new ListNode(2);
        ListNode root4 = new ListNode(3);
        ListNode root5 = new ListNode(4);
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root4.next = root3;
        root3.next = root5;
        IntersectingLinkedList intersectingLinkedList = new IntersectingLinkedList();
        System.out.println(intersectingLinkedList.getIntersectionNode(root,root4).val);
    }
}
