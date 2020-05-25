package Finished;

public class NetxInDictionary {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.57%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了43.75%的用户
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int help;
        for (int i = nums.length-1; i >0 ; i--) {
            if (nums[i]>nums[i - 1]){
                for (int j = nums.length-1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]){
                        swap(i -1,j,nums);
                        break;
                    }
                }
                help = (nums.length-i)>>1;
                for (int j = 0; j < help; j++) {
                    swap(i+j,nums.length-1-j,nums);
                }
                return;
            }
        }
        help = nums.length>>1;
        for (int j = 0; j <= help; j++) {
            swap(j,nums.length-1-j,nums);
        }
        return;
    }
    private void swap(int pos1,int pos2,int[] nums){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        NetxInDictionary netxInDictionary = new NetxInDictionary();
        netxInDictionary.nextPermutation(new int[]{6,8,7,6,5,4});
    }
}
