package Finished;

import java.util.Stack;

public class CheckRightPop {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了94.16%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length!=pushed.length) return false;
        Stack<Integer> stack = new Stack<>();
        int pos_in = 0;
        int pos_out = 0;
        while (true) {
            if (pos_in==pushed.length){
                if (stack.size()==0) return true;
                while (!stack.empty()){
                    if (stack.pop()!=popped[pos_out++]) return false;
                }
                return true;
            }
            if (pushed[pos_in] == popped[pos_out]) {
                pos_in++;
                pos_out++;
            } else {

                if (stack.size()!=0&&popped[pos_out] == stack.peek()) {
                    stack.pop();
                    pos_out++;
                } else stack.push(pushed[pos_in++]);
            }
        }
    }

    public static void main(String[] args) {
        CheckRightPop checkRightPop = new CheckRightPop();
        System.out.println(checkRightPop.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
