package Finished.dataStructure;

import java.util.Arrays;

/**
 * 执行用时：7 ms, 在所有 Java 提交中击败了88.35%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class IncrStack {
    int[]arr;
    int size;
    int capacity;
    public IncrStack(int maxSize) {
        arr = new int[maxSize];
        capacity = maxSize;
    }

    public void push(int x) {
        if (size < capacity) arr[size++] = x;
    }

    public int pop() {
        return size>0?arr[--size]:-1;
    }

    public void increment(int k, int val) {
        int min = Math.min(k,size);
        for (int i = 0; i < min; i++) {
            arr[i] = arr[i] + val;
        }
    }

    public static void main(String[] args) {
        IncrStack incrStack = new IncrStack(20);
        System.out.println(incrStack.pop());
        incrStack.push(4);
        incrStack.push(5);
        incrStack.push(1);
        incrStack.push(30);
        System.out.println(incrStack.pop());
        System.out.println(Arrays.toString(incrStack.arr));
        incrStack.increment(2,3);
        System.out.println(Arrays.toString(incrStack.arr));
        incrStack.increment(10,5);
        System.out.println(Arrays.toString(incrStack.arr));
    }
}
