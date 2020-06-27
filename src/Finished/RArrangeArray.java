package Finished;

public class RArrangeArray {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
//        int left = 1;
//        int right = n;
//        boolean mark = false;
//        while (){
//            nums[left]^=nums[right];
//            nums[right]^=nums[left];
//            nums[left]^=nums[right];
//            if (!mark){
//                left++;
//            }
//            else right++;
//            mark = !mark;
//        }
        int[] ans = new int[nums.length];
        int index1 = 0;
        for (int i = 0; i < n; i++) {
            ans[index1++] = nums[i];
            ans[index1++] = nums[i+n];
        }
        return ans;

    }
}
