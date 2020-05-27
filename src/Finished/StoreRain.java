package Finished;

import java.util.Stack;

public class StoreRain {
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了31.65%的用户
     * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了12.86%的用户
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {

            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty())
                    break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(i);

        }
        return ans;
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
     * 内存消耗 :39 MB, 在所有 Java 提交中击败了12.86%的用户
     * @param height
     * @return
     */
    public int trap_2pointers(int[] height) {
        int left=0;
        int right = height.length-1;
        int ans = 0;
        int h;
        while (left<right){
            if(height[left]>height[right]){
                h = height[right];
                while (height[--right] < height[left]){
                    if (height[right]>h) h = height[right];
                    else ans+=h-height[right];
                }
            }
            else {
                h = height[left];
                while (height[++left] < height[right]){
                    if (height[left]>h) h = height[left];
                    else ans+=h-height[left];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        StoreRain storeRain = new StoreRain();
        System.out.println(storeRain.trap_2pointers(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
