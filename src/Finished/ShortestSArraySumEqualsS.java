package Finished;

public class ShortestSArraySumEqualsS {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了83.23%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 1;
        int curr = nums[0];
        int ans = nums.length+1;
        while (left<nums.length){
            while (right<nums.length&&curr<s){
                curr+=nums[right++];
            }
            if (curr>=s){
                ans = Math.min(ans,right-left);//update
            }

            curr -=  nums[left++];
        }
        return ans==(nums.length+1)?0:ans;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestSArraySumEqualsS().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
