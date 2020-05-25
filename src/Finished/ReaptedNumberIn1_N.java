package Finished;

public class ReaptedNumberIn1_N {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了75.41%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int ans = 0;
        int help;
        for (int i = 0; i < nums.length; i++) {
            help = nums[i]>0?nums[i]:(-nums[i]);
            if (nums[help]<0) return help;
            nums[help] = -nums[help];
        }
        return ans;
    }

    public static void main(String[] args) {
        ReaptedNumberIn1_N reaptedNumberIn1_n  = new ReaptedNumberIn1_N();
        System.out.println(reaptedNumberIn1_n.findDuplicate(new int[]{1,3,5,2,3,3}));
    }
}
