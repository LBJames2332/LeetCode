import java.util.HashMap;
import java.util.Map;

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

    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了68.49%的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了7.69%的用户
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> front = new HashMap<>();
        front.put(0,1);
        int sum = 0;
        int help;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            help = sum - k;
            if (front.containsKey(help)){
                count+=front.get(help);
            }
            front.put(sum,front.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSumOfSStrEqualsK countSumOfSStrEqualsK = new CountSumOfSStrEqualsK();
        System.out.println(countSumOfSStrEqualsK.subarraySum2(new int[]{0,0,0,0,0,0,0,0,0,0},0));
    }
}
