package Finished;

import java.util.Arrays;

public class SlideWindow {
    Node head = new Node(1,1);
    Node tail = new Node(1,1);

    /**
     * 执行用时 :8 ms, 在所有 Java 提交中击败了84.09%的用户
     * 内存消耗 :51.5 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        head.next =tail;
        tail.prev = head;
        int[] output = new int[nums.length-k+1];
        addToTail(new Node(nums[0],0));
        for (int i = 1; i < k; i++) {
            if (tail.prev==head||nums[i] <= tail.prev.val){
                addToTail(new Node(nums[i],i));
            }
            else {
                do{
                    removeFromTail();
                }while (tail.prev!=head&&tail.prev.val < nums[i]);
                addToTail(new Node(nums[i],i));
            }
        }
        int index =0;
        output[index++] = head.next.val;
        for (int i = k; i < nums.length; i++) {
            if (head.next.index == i - k){
                head.next = head.next.next;
                head.next.prev = head;
            }
            if (tail.prev==head||nums[i] <= tail.prev.val){
                addToTail(new Node(nums[i],i));
            }
            else {
                do{
                    removeFromTail();
                }while (tail.prev!=head&&tail.prev.val < nums[i]);
                addToTail(new Node(nums[i],i));
            }
            output[index++] = head.next.val;
        }
        return output;
    }
    public void removeFromTail(){
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
    public void addToTail(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public static void main(String[] args) {
        SlideWindow slideWindow = new SlideWindow();
        System.out.println(Arrays.toString(slideWindow.maxSlidingWindow(new int[]{5,3,4},1)));
    }

}
class Node{
    int val;
    int index;
    Node prev;
    Node next;

    public Node(int val,int index) {
        this.val = val;
        this.index = index;
    }
}