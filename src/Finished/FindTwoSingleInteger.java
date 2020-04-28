package Finished;

public class FindTwoSingleInteger {
    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了95.47%的用户
     * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int all = nums[0];
        for (int i = 1; i < nums.length; i++) {
            all^=nums[i];
        }
        int center = 1;
        while ((center&all)==0){
            center<<=1;
        }
        //找到二进制从低到高第一个为1的数
        //因为是两个目标值的异或为1的数
        //所以这两个数分别在这一位为1和这一位为0的两个组里面
        //分组就找到了
        boolean lseted = false;
        boolean rseted = false;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&center)==0){
                if (!lseted) {
                    ans[0] = nums[i];
                    lseted = true;
                }
                else ans[0]^=nums[i];
            }
            else {
                if (!rseted) {
                    ans[1] = nums[i];
                    rseted = true;
                }
                else ans[1]^=nums[i];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        FindTwoSingleInteger findTwoSingleInteger = new FindTwoSingleInteger();
        for (int i:findTwoSingleInteger.singleNumbers(new int[]{1,2,5,2})) System.out.println(i);
    }
}
