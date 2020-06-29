package Finished.MorrelVote;

public class MorreVote {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.78%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了12.86%的用户
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate=nums[0];
        int n_tickets=0;
        for (int v:nums){
            if (candidate==v){
                n_tickets++;
            }
            else {
                n_tickets--;
                if (n_tickets<0) {
                    candidate = v;
                    n_tickets = 1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new MorreVote().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
