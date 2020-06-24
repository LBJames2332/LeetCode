package Finished;

public class StoreWater {
    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了71.67%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了16.43%的用户
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[right]>height[left]){
                left++;
            }
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new StoreWater().maxArea(new int[]{1,2,4,3}));
    }
}
