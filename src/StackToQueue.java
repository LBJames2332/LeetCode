import java.util.Stack;

/**实现一个MyQueue类，该类用两个栈来实现一个队列。
 * 执行用时 :13 ms, 在所有 Java 提交中击败了51.71%的用户
 * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class StackToQueue {
    private  Stack<Integer> stack_1;
    private  Stack<Integer> stack_2;
    /** Initialize your data structure here. */
    public StackToQueue() {
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack_2.empty()) stack_1.push(stack_2.pop());
        stack_1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack_1.empty()) stack_2.push(stack_1.pop());
        return  stack_2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stack_1.empty()) stack_2.push(stack_1.pop());
        return  stack_2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack_1.empty()&&stack_2.empty()) return true;
        return false;
    }

    public static void main(String[] args) {
        StackToQueue q = new StackToQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
