package Finished;

import java.util.Arrays;

public class MaxGap {
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了46.16%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了14.29%的用户
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length<2) return 0;
        int[][] min_max = new int[nums.length+1][2];
        boolean[] mark = new boolean[nums.length+1];
        System.out.println(Arrays.toString(mark));
        int max=nums[0];
        int min=nums[0];
        for (int i = 1; i < nums.length; i++) {
            max= Math.max(max,nums[i]);
            min= Math.min(min,nums[i]);
        }
        //System.out.println(max+"  "+min);
        double size = (double) (max - min)/mark.length;
        //System.out.println(size);
        for (int i = 0; i < nums.length; i++) {

            int pos = (nums[i]==max)?nums.length:(int) ((nums[i]-min)/size);
            System.out.println(nums[i]+" "+pos);
            if (mark[pos]){
                min_max[pos][0] = Math.min(min_max[pos][0],nums[i]);
                min_max[pos][1] = Math.max(min_max[pos][1],nums[i]);
            }
            else {
                min_max[pos][0] = nums[i];
                min_max[pos][1] = nums[i];
                mark[pos] = true;
            }

        }
        int ans = (int) size;
        int help;
        for (int i = 0; i < nums.length; i++) {
            if (mark[i]){
                if (mark[i+1]){
                    ans = Math.max(min_max[i+1][0]-min_max[i][1],ans);
                }
                else {
                    help = min_max[i][1];
                    while (!mark[++i]);
                    ans = Math.max(min_max[i--][0]-help,ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( new MaxGap().maximumGap(new int[]{1,3,100}));
    }
}
