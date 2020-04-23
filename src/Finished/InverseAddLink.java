package Finished;

public class InverseAddLink {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 执行用时 :3 ms, 在所有 Java 提交中击败了36.98%的用户内存消耗 :39.8 MB, 在所有 Java 提交中击败了94.26%的用户
     * @return
     */
    public static void main(String[] args) {


        ListNode l1 = new ListNode(5,null);
        ListNode l2 = new ListNode(5,null);
        printLink(addTwoNumbers(l1,l2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int help1;
        int help2 = 0;
        ListNode curr = new ListNode(0,null);
        ListNode head;
        if (l1!=null) head = l1;
        else {if(l2!=null) head =  l2;
        else return null;}
        curr.next = head;
        while (!(l1==null||l2==null)){
            curr = curr.next;
            help1 = l1.val+l2.val+help2;
            curr.val = help1%10;
            help2 = help1/10;
            curr.next = l1.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1!=null){
            while (help2!=0){
                curr = curr.next;
                help1 = curr.val+help2;
                curr.val = help1%10;
                help2 = help1/10;
                curr.next = l1.next;
                l1 = l1.next;
                if (curr.next == null) break;
            }
            if (help2!=0){
                curr.next = new ListNode(help2,null);
            }
        }
        if (l2!=null){
            curr.next = l2;
            while (help2!=0){
                curr = curr.next;
                help1 = curr.val+help2;
                curr.val = help1%10;
                help2 = help1/10;
                curr.next = l2.next;
                l2 = l2.next;
                if (curr.next == null) break;
            }
            if (help2!=0){
                curr.next = new ListNode(help2,null);
            }
        }
        if (help2!=0){
            curr.next = new ListNode(help2,null);
        }
        return head;

    }
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void printLink(ListNode root){
        while (root!=null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}
