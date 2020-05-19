package Finished;

public class SortedLinkedListToBBST {
    /**
     * 有序链表转二叉搜索树
     * 尝试用O(logn)的空间复杂度完成吧
     * 思路大概是找中间节点，然后左边是左部分的中间节点，以此类推。
     */

    ListNode slow = null;
    ListNode fast = null;

    /**
     * 执行用时 :55 ms, 在所有 Java 提交中击败了5.53%的用户内存消耗 :
     * 41.8 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        TreeNode root = SearchMidNode(head,null);
        return root;
    }

    private TreeNode SearchMidNode( ListNode start, ListNode end) {
        ListNode prev=null;
        ListNode next;

        if(start.next ==null) return new TreeNode(start.val);
        if (start.next==end||start.next.next==null){
            TreeNode root = new TreeNode(start.val);
            root.right = new TreeNode(start.next.val);
            return root;
        }
        if (end==null) System.out.println(start.val);
        else  System.out.println(start.val+" "+end.val);
        if (start == null) return null;
        if (start == end) return new TreeNode(start.val);
        slow = start;
        fast = start.next;
        if (end==null){
            while (fast!=null&&fast.next!=null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

        }
        else {
            while (fast!=end.next&&fast!=end){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        next = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = SearchMidNode(start,prev);
        root.right = SearchMidNode(next,end);
        return root;
    }



    static class Node{
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
    class TreeNode extends  Node{
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            super(val);
        }
    }
    static class ListNode extends  Node{
        ListNode next;

        public ListNode(int val) {
            super(val);
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        SortedLinkedListToBBST sortedLinkedListToBBST = new SortedLinkedListToBBST();
        System.out.println(sortedLinkedListToBBST.sortedListToBST(head));
    }
}
