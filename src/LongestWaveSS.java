public class LongestWaveSS {
    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了13.25%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了14.29%的用户
     * @param nums
     * @return
     */
    public int wiggleMaxLength_EasyDP(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp_i = new int[length];
        int[] dp_d = new int[length];
        dp_i[0] = 1;
        dp_d[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >=0 ; j--) {

                if (nums[j]>nums[i]) {
                    dp_d[i] = Math.max(dp_d[i],dp_i[j]);
                }
                if (nums[j]<nums[i]) {
                    dp_i[i] = Math.max(dp_i[i],dp_d[j]);
                }
            }
            dp_d[i]++;
            dp_i[i]++;
            max = Math.max(max,dp_d[i]);
            max = Math.max(max,dp_i[i]);

        }
        return max;
    }

    /**
     * linerDP
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了14.29%的用户
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp_i = new int[length];
        int[] dp_d = new int[length];
        dp_i[0] = 1;
        dp_d[0] = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]){
                dp_d[i] = dp_i[i - 1]+1;
                dp_i[i] = dp_i[i - 1];
            }
            else if (nums[i] > nums[i - 1]){
                dp_d[i] = dp_d[i - 1];
                dp_i[i] = dp_d[i - 1] + 1;
            }
            else {
                dp_d[i] = dp_d[i - 1];
                dp_i[i] = dp_i[i - 1];
            }


        }
        return Math.max(dp_d[length - 1],dp_i[length - 1]);
    }


    public static void main(String[] args) {
        LongestWaveSS longestWaveSS = new LongestWaveSS();
        System.out.println(longestWaveSS.wiggleMaxLength(new int[]{33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15}));
    }
}
