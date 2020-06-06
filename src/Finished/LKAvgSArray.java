package Finished;

public class LKAvgSArray {
    /**
     * 求长度为K的平均值大于等于threshold的子数组的个数
     * 执行用时 :4 ms, 在所有 Java 提交中击败了61.93%的用户
     * 内存消耗 :48 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int pointer1 = 0;
        int pointer2 = k-1;

        int sum = 0;
        double avg;
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
        int ans = 0;
        avg = (double) sum/k;
        if (avg >= threshold) ans++;
        while (pointer2!=arr.length-1){
            sum += arr[++pointer2]-arr[pointer1++];
            avg = (double) sum/k;
            if (avg >= threshold) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LKAvgSArray lkAvgSArray = new LKAvgSArray();
        System.out.println(lkAvgSArray.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3},3,5));
    }
}
