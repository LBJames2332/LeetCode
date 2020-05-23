package Finished;

import java.util.Arrays;
import java.util.Stack;

public class NextMaxNumber {
    int[] ans;
    int[] nums;

    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了74.69%的用户
     * 内存消耗 :44 MB, 在所有 Java 提交中击败了12.50%的用户
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        ListNode node = head;
        int num = 0;
        while (node!=null){
            num++;
            node = node.next;
        }
        ans = new int[num];
        nums = new int[num];
        node = head;
        num = 0;

        while (node!=null){
            nums[num++] = node.val;
            node = node.next;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[num-1]);
        for (int i = num-2; i >-1 ; i--) {
            while (!stack.isEmpty()&&nums[i]>stack.peek()){
                stack.pop();
            }
            if (!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        NextMaxNumber nextMaxNumber = new NextMaxNumber();
        System.out.println(Arrays.toString(nextMaxNumber.nextLargerNodes(node)));
    }
}
