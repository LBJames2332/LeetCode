package Valuable_for_Practise;

public class ShortestSStrToSortForSortedArray {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了89.60%的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了19.05%的用户
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<2) return 0;
        int from =  0;

        int end = nums.length - 1;
        int to =  end;
        int min = nums[end];
        int max = nums[0];
        boolean mark_min = false;
        boolean mark_max = false;
        if (nums[0]>nums[1]) {
            mark_max = true;
            max = Math.max(max,nums[0]);
        }
        if (nums[end]<nums[end -1 ]){
            mark_min = true;
            min = Math.min(min,nums[end]);
        }
        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i]>nums[i + 1]) {
                mark_max = true;
                max = Math.max(max,nums[i]);
                continue;
            }
            if (nums[i]<nums[i -1 ]){
                mark_min = true;
                min = Math.min(min,nums[i]);
            }
        }
        if (!(mark_max||mark_min)) return 0;
        if (mark_max){
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]>min) {
                    from = j;
                    break;
                }
            }
        }
        if (mark_min){
            for (int j = end; j > -1; j--) {
                if (nums[j]<max) {
                    to = j;
                    break;
                }
            }
        }

        return to - from+1;
    }

    public static void main(String[] args) {
        ShortestSStrToSortForSortedArray shortestSStrToSortForSortedArray = new ShortestSStrToSortForSortedArray();
        System.out.println(shortestSStrToSortForSortedArray.findUnsortedSubarray(new int[]{-3,6,4,8,10,9,15,1}));
    }
}
