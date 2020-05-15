public class CountSumOfSStrEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[][] sum = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i][i] = nums[i];
            if (nums[i] ==k)count++;
            for (int j = i+1; j < nums.length; j++) {
                sum[i][j] = sum[i][j-1] + nums[j];
                if (sum[i][j]== k) count++;
            }
        }
        return count;
    }
}
