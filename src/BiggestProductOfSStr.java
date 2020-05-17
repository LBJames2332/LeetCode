public class BiggestProductOfSStr {
    //连续子串的最大乘积

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.15%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int product_plus = nums[0];
        //plus存储的是正常逻辑下的最大值
        int product_minus = product_plus;
        //minus会把当前的最大相反情况结果存下来，若是接下来遇到负数，则有机会逆袭
        int max = product_plus;
        int plus;
        int minus;
        for (int i = 1; i < nums.length; i++) {
            plus = product_plus*nums[i];
            minus = product_minus*nums[i];
            product_plus = (plus>minus)?((plus>nums[i])?plus:nums[i]):((minus>nums[i])?minus:nums[i]);
            product_minus = (plus<minus)?((plus<nums[i])?plus:nums[i]):((minus<nums[i])?minus:nums[i]);
            max = (product_minus<product_plus)?((product_plus<max)?max:product_plus):((product_minus<max)?product_minus:max);

        }
        return max;
    }
}
