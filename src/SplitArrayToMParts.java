public class SplitArrayToMParts {
    int[] N;
    int M;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        N = nums;
        M = m;
        int sum = 0;
        int max = 0;
        for (int val:nums){
            sum += val;
            max = Math.max(max,val);
        }
        int left = max;
        int right = sum;
        while (left < right){
            int mid = left + ((right - left)>>>1);
            if (check(mid)){
                right = mid;//缩小x
            }
            else left = mid + 1;//放大x
        }
        return left;
    }
    //检测能否把数组分割为m个最大和<=x的片段
    private boolean check(int x){//x一定≥单个元素的值
        int div_n = 1;
        int count = 0;
        for (int val:N){
            count+=val;
            if (count>x){
                count = val;
                div_n ++;
            }
        }
        return div_n<=M;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayToMParts().splitArray(new int[]{7,2,5,10,8},2));
    }
}
