package Finished;

public class SumOfSubSquenceWithRestrict {
    //    public int constrainedSubsetSum(int[] nums, int k) {
//        int length = nums.length;
//        int[] dp = new int[length];
//        int max_before;
//        for (int i = 0; i < length; i++) {
//            max_before = 0;
//            for (int j = 0; j < i; j++) {
//                max_before = max_before>dp[j]?max_before:dp[j];
//            }
//            dp[i] = max_before+nums[i];
//        }
//        max_before = dp[length - 1];
//        for (int i = 2; i <= k+1; i++) {
//            max_before = max_before>dp[length - i]?max_before:dp[length - i];
//        }
//        return max_before;
//    }
    Node head = new Node(0,1);
    Node tail = new Node(0,1);

    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了87.73%的用户
     * 内存消耗 :48.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @param k
     * @return
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        head.next =tail;
        tail.prev = head;
        int length = nums.length;
        int[] dp = new int[length];
        int max;
        max = nums[0];
        for (int i = 0; i < k; i++) {

            dp[i] = (head.next.val>0?head.next.val:0)+nums[i];
            if (tail.prev==head||dp[i] <= tail.prev.val){
                addToTail(new Node(dp[i],i));
            }
            else {
                do{
                    removeFromTail();
                }while (tail.prev!=head&&tail.prev.val < dp[i]);
                addToTail(new Node(dp[i],i));
            }

        }
        max = head.next.val;
        for (int i = k; i < length; i++) {
            if (head.next.index == i - k - 1){
                head.next = head.next.next;
                head.next.prev = head;
            }
            dp[i] = (head.next.val>0?head.next.val:0)+nums[i];
            if (tail.prev==head||dp[i] <= tail.prev.val){
                addToTail(new Node(dp[i],i));
            }
            else {
                do{
                    removeFromTail();
                }while (tail.prev!=head&&tail.prev.val < dp[i]);
                addToTail(new Node(dp[i],i));
            }
            max = max > head.next.val?max:head.next.val;
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        SumOfSubSquenceWithRestrict sumOfSubSquenceWithRestrict = new SumOfSubSquenceWithRestrict();
        System.out.println(sumOfSubSquenceWithRestrict.constrainedSubsetSum(new int[]{-5266,4019,7336,-3681,-5767},2));
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
    class Node{
        int val;
        int index;
        Node prev;
        Node next;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
