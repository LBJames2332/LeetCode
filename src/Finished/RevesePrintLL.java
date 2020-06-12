package Finished;

import Tools.Classes.ListNode;

public class RevesePrintLL {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode help = head;
        int count = 1;
        while (help!=null){
            help = help.next;
            count++;
        }
        int[] ans = new int[count];
        count--;
        while (head!=null){
            ans[count--] = head.val;
            head = head.next;
        }
        return ans;
    }
}
