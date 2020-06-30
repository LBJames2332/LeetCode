package Finished.Greedy;

public class JumpGame {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.85%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了12.50%的用户
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length<2) return true;
        int pos = 0;///一开始在0位置处
        int max = nums[0];
        while (max<nums.length-1){//不能到终点
            //这里已经是i==pos时候的情况了//当前位置上能到的最远点为当前位置+当前位置能跳的最大距离
            int max2 = max;
            for (int i = pos+1; i <= max; i++) {
                int calcu_result = nums[i]+i;
                if (calcu_result > max2){
                    max2 = calcu_result;
                    pos = i;
                }
            }
            if (max == max2) return false;
            max = max2;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
    }
}
