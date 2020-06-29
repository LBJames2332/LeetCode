package Finished.heap;

import java.util.Arrays;

public class SmallestKNumbers {
    int size;
    int[] heap;
    int capacity;

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了63.55%的用户
     * 内存消耗：49.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {

        capacity = k;
        heap = new int[k];
        //找最小的k个数做最大堆，比堆中最大的（堆顶最大）小的会加入堆中
        for (int val:arr) {
            if (size<k) HeapInsert(val);
            else {
                if (val< heap[0]) Heapify(val);
            }
        }

        System.out.println(Arrays.toString(heap));
        return null;

    }

    private void Heapify(int val) {
        heap[0] = val;
        int pos = 0;
        int c_pos1 = 1;
        int c_pos2 = 2;
        boolean loop = true;
        int temp;
        while (loop){
            loop = false;
            c_pos1 = (pos<<1)+1;
            c_pos2 = c_pos1+1;
            if (c_pos1>=capacity) return;
            if (c_pos2==capacity){
                if (heap[pos]<heap[c_pos1]){
                    temp = heap[pos];
                    heap[pos] = heap[c_pos1];
                    heap[c_pos1] = temp;
                }
                return;
            }
            else {
                if (heap[c_pos1]>heap[c_pos2]){
                    if (heap[pos]<heap[c_pos1]){
                        temp = heap[pos];
                        heap[pos] = heap[c_pos1];
                        heap[c_pos1] = temp;
                        loop = true;
                        pos = c_pos1;
                    }

                }
                else {
                    if (heap[pos]<heap[c_pos2]){
                        temp = heap[pos];
                        heap[pos] = heap[c_pos2];
                        heap[c_pos2] = temp;
                        loop = true;
                        pos = c_pos2;
                    }

                }
            }

        }
    }

    private void HeapInsert(int val) {
        int pos = size++;
        heap[pos] = val;
        int p_pos = (pos-1)>>1;
        int temp;
        while (pos>0&&heap[pos] > heap[p_pos]){//比父亲大，网上挪吧
            temp = heap[pos];
            heap[pos] = heap[p_pos];
            heap[p_pos] = temp;
            pos = p_pos;
            p_pos = (pos-1)>>1;
        }
    }

    public static void main(String[] args) {
        new SmallestKNumbers().smallestK(new int[]{1,3,5,7,2,4,6,8},4);
    }
}
