import java.util.Stack;

public class BiggestRectangle {
    /**
     * 执行用时 :10 ms, 在所有 Java 提交中击败了94.04%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了56.52%的用户
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Info> stack = new Stack<>();
        stack.add(new Info(0,-1));
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.size()==1||heights[i]>stack.peek().val){
                stack.add(new Info(heights[i],i));
            }
            else if (heights[i] < stack.peek().val){
                while (heights[i] < stack.peek().val){
                    max = Math.max(max,stack.pop().val*(i-stack.peek().pos-1));
                }

                stack.add(new Info(heights[i],i));
            }
            else {
                stack.peek().pos = i;
            }
        }
        while (stack.size()>1) {
            max = Math.max(max,stack.pop().val*(heights.length-stack.peek().pos-1));
        }
        return max;

    }
    class Info{
        int val;
        int pos;

        public Info(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        BiggestRectangle biggestRectangle = new BiggestRectangle();
        System.out.println(biggestRectangle.largestRectangleArea(new int[]{0,0,0,0,0,13213123}));
    }
}
