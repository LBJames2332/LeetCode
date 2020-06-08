public class SUMRange {
    int[] sum;

    /**
     * 执行用时 :10 ms, 在所有 Java 提交中击败了99.10%的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了43.48%的用户
     * @param nums
     */
    public SUMRange(int[] nums) {
        sum = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = nums[i]+sum[i];
        }
        return;
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }

    public static void main(String[] args) {
        SUMRange sumRange = new SUMRange(new int[]{-2, 0, 3, -5, 2, -1});
    }
}
