package Finished;

public class ArrayJump {
    /**DP法
     * 执行用时 :600 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了5.00%的用户
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] n_jump = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+nums[i]; j++) {
                if (j >= n_jump.length) break;
                if (n_jump[j]==0) n_jump[j] = n_jump[i]+1;
                else n_jump[j] = (n_jump[j] < (n_jump[i] + 1))?n_jump[j]:(n_jump[i] + 1);

            }
        }
        return n_jump[n_jump.length-1];
    }

    /**
     * Greedy
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int step = 0;
        int end = 0;
        int max_position = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max_position = (max_position>(nums[i]+i))?max_position:(nums[i]+i);
            if (i == end){
                step++;
                end = max_position;
            }
        }
        return step;
    }
    public static void main(String[] args) {
        ArrayJump arrayJump = new ArrayJump();
        System.out.println(arrayJump.jump(new int[]{2,3,1,1,4}));
    }
}
