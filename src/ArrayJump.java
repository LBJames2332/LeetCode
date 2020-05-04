public class ArrayJump {
    /**
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

    public static void main(String[] args) {
        ArrayJump arrayJump = new ArrayJump();
        System.out.println(arrayJump.jump(new int[]{2,3,1,1,4}));
    }
}
