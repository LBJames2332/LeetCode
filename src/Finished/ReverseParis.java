package Finished;

public class ReverseParis {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * 执行用时 :38 ms, 在所有 Java 提交中击败了63.75%的用户
     * 内存消耗 :48.4 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        System.out.println(reversePairs(nums));
    }
    public static int reversePairs(int[] nums) {
        int count_all = 0;
        int[] count = new int[nums.length];
        Count(0,nums.length-1,count,nums);
        for (int i = 0; i < count.length; i++) {
            count_all += count[i];
        }
        return count_all;

    }

    public static void Count(int start,int end,int[] count,int [] nums) {
        if (start>=end) return;
        int middle = (end + start)>>1;

        Count(start,middle,count,nums);
        Count(middle+1,end,count,nums);
        int i = start;
        int j = middle+1;
        int[] a = new int[end-start+1];
        int now = 0;
        while (i<=middle&&j<=end){
            if (nums[j]<nums[i]){
                count[j]+=middle-i+1;
                a[now++] = nums[j++];
            }
            else a[now++] = nums[i++];
        }
        while (i<=middle) a[now++] = nums[i++];
        while (j <= end) a[now++] = nums[j++];
        i = start;
        for (int k = 0; k < a.length; k++) {
            nums[i++] = a[k];
        }
    }

    public static void swap(int[] array,int pos1,int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
