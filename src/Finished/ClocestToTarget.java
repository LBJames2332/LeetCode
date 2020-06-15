package Finished;

import java.util.Arrays;

public class ClocestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] qianzhuihe = new int[arr.length+1];//第i个位置表示前i个数的和
        //qianzhuihe[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            qianzhuihe[i] = qianzhuihe[i-1]+arr[i-1];
        }
        int l = 0;
        int r = arr[arr.length-1];
        int ans = 0;
        while (l<=r){
            int mid = (l+r)>>1;
            int index = Arrays.binarySearch(arr,mid);
            if (index < 0 ) index = -index-1;
            int sum = qianzhuihe[index]+ (arr.length-index)*mid;
            if (sum <= target){
                ans = mid;
                l=mid+1;
            }
            else {
                r = mid-1;
            }
        }
        //System.out.println(target);
        int gap_small = Math.abs(target - check(arr,ans));
        int gap_big = Math.abs(check(arr,ans+1) - target);
        //System.out.println(gap_big+" "+gap_small+"  "+ans);
        return gap_small>gap_big?ans+1:ans;
    }
    public int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        new ClocestToTarget().findBestValue(new int[]{2,3,5},11);
    }

}
