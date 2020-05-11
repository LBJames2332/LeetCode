package Finished;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 执行用时 :7 ms, 在所有 Java 提交中击败了85.72%的用户
 * 内存消耗 :41.9 MB, 在所有 Java 提交中击败了13.25%
 * 的用户
 */
public class MinStack {
    List<Integer> minStack;
    Stack<Integer> min_queue;
    public MinStack() {
        minStack = new ArrayList<>();
        min_queue = new Stack<>();
    }

    public void push(int x) {
        minStack.add(x);
        if (min_queue.size()==0||x <= min_queue.get(min_queue.size() - 1)){
            min_queue.push(x);
        }
    }

    public void pop() {
        System.out.println(top());
        if (min_queue.peek()==top()) min_queue.pop();
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        return minStack.get(minStack.size() - 1);
    }

    public int getMin() {
        return min_queue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
