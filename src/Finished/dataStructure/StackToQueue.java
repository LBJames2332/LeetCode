package Finished.dataStructure;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> store;
    Stack<Integer> output;

    /**
     * 执行用时：56 ms, 在所有 Java 提交中击败了76.97%的用户
     * 内存消耗：47.6 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public StackToQueue() {
        store = new Stack<>();
        output = new Stack<>();
    }

    public void appendTail(int value) {
        store.push(value);
    }

    public int deleteHead() {
        if (!output.isEmpty()) return output.pop();
        if (store.isEmpty()) return -1;
        while (!store.isEmpty()) output.push(store.pop());
        return output.pop();
    }

}
