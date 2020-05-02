public class LongestArithmeticSequenceInDiff {
    /**
     * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
     *
     */
    int ans = 1;
    public int longestSubsequence(int[] arr, int difference) {
        int length = 1;
        for (int i = 0; i < arr.length-1; i++) {
            length = SearchFrom(arr,difference,arr[i],i+1,length);
            ans = ans > length ? ans : length;
            length = 1;
        }
        return ans;
    }

    private int SearchFrom(int[] arr, int difference, int prev_val, int start,int length) {
        int prev_length = length;
        int return_val;
        for (int j = start; j < arr.length; j++) {
            if (arr[j] - prev_val == difference){
                return_val = SearchFrom(arr,difference,arr[j],j+1,length+1);
                prev_length = (prev_length>return_val)?prev_length:return_val;
            }
        }

        return prev_length;
    }

    public static void main(String[] args) {
        LongestArithmeticSequenceInDiff longestArithmeticSequenceInDiff = new LongestArithmeticSequenceInDiff();
        System.out.println(longestArithmeticSequenceInDiff.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }
}
