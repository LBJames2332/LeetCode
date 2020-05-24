package Valuable_for_Practise;

public class FindCenterNumber {
    /**
     * 找到两个有序数组（长度m,n）的中位数
     * 要求：log(m+n)
     * 执行用时 :3 ms, 在所有 Java 提交中击败了65.93%的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了100.00%
     * 的用户
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays3(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;
        int totalLeft = (m+n)>>1;
        int i,j;
        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            i = (left + right) >> 1;
            j = totalLeft- i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {//一个目测可行划分，记录一下值
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            }
            else {//必然不可行的划分，直接重定位
                right = i - 1;
            }
        }

        return ((m + n) & 1) == 0 ? (median1 + median2) / 2.0 : median1;
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return this.findMedianSortedArrays2(nums2,nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) >> 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) >> 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) & 1) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;


        if (len1 > len2){
            int[] temp  = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = len2;
            len2 = nums2.length;
        }
        if (len1 == 0){
            int help = (len2-1)>>1;
            if ((len2&1)==1) return nums2[help];
            else return (double)((nums2[help]+nums2[help+1])>>1);
        }
//        System.out.println(Arrays.toString(nums1));
        int totalLeft = (len1+len2)>>1;
        int s1 = 0;
        int e1 = len1 - 1;
        int mid1 = 0;
        int mid2 = 0;
        while (s1 <= e1){
            System.out.println(s1+"s,e"+e1);
            mid1 = s1 + ((e1 - s1)>>1);
            mid2 = totalLeft - mid1;
            System.out.println(mid1+" "+mid2);
            if (mid1==len1-1){
                if (mid2>=len2-1||nums1[mid1]>nums2[mid2+1]) mid1++;

                break;
            }
            if (mid1>=len1)break;
            if(mid2==len2-1){
                if (mid1>=len1-1||nums2[mid2]<=nums1[mid1+1])mid2++;
                break;
            }
            if (mid2>=len2)break;
            if (nums1[mid1]<=nums2[mid2+1]
                    &&nums2[mid2]<=nums1[mid1+1]){
                break;
            }
            else {
                if (nums1[mid1] > nums2[mid2+1]) e1 = mid1 - 1;
                else s1 = mid1 + 1;
            }
        }
        System.out.println(mid1+" "+mid2);
        int num1Left = (mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
        int num1right = (mid1==len1)?Integer.MAX_VALUE:nums1[mid1];
        int num2Left = (mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
        int num2right = (mid2==len2)?Integer.MAX_VALUE:nums2[mid2];
        System.out.println(num1Left+" "+num1right);
        System.out.println(num2Left+" "+num2right);
        if (((len1+len2)&1) == 1){
            //奇数个
            return Math.max(num1Left,num2Left);
        }
        else return (double)((Math.max(num1Left,num2Left)+Math.min(num1right,num2right))/2.0);


    }
    public static void main(String[] args) {
        FindCenterNumber findCenterNumber = new FindCenterNumber();
        System.out.println(findCenterNumber.findMedianSortedArrays3(new int[]{1,3},new int[]{2}));
    }
}
