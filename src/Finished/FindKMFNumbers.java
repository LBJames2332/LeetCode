package Finished;

import java.util.*;
import java.util.Queue;

public class FindKMFNumbers {
    class MyBigHeap{
        Map<Integer,Integer> n_set  = new HashMap<>();//存的是元素，元素索引，所以要和heap同步更新
        Node[] heap;//存的是出现次数
        int size;

        public MyBigHeap(int size) {
            this.heap = new Node[size];
        }

        public void addOrLevelUp(int num){
            if (!n_set.containsKey(num)) add(num);
            else LU(num);
        }

        private void LU(int num) {

            int prev_pos = n_set.get(num);
            heap[prev_pos].count++;//可能要往上移动
            while ((prev_pos>0)&&(heap[prev_pos].count>heap[(prev_pos-1)>>1].count)){
                Node temp = heap[prev_pos];
                n_set.put(heap[(prev_pos-1)>>1].val,prev_pos);
                heap[prev_pos] = heap[(prev_pos-1)>>1];
                heap[(prev_pos-1)>>1] = temp;
                prev_pos = (prev_pos-1)>>1;
            }
            n_set.put(num,prev_pos);//更新新的pos值

        }

        private void add(int num) {
            heap[size] = new Node(1,num);
            n_set.put(num,size++);
        }

        public int remove() {
            int node_pos;
            int return_value = heap[0].val;
            heap[0] = heap[--size];
            int pos  = 0;
            int help1 = 0;
            int help2  = 0;
            while (pos<<1+1<size){
                help1 = heap[(pos<<1)+1].count;
                help2 = ((pos<<1)+2<size)?heap[(pos<<1)+2].count:-1;

                if (heap[pos].count < Math.max(help1,help2)){
                    node_pos = (help1<help2)?(pos<<1)+2:(pos<<1)+1;

                    Node temp = heap[pos];
                    n_set.put(heap[node_pos].val,pos);
                    heap[pos] = heap[node_pos];
                    heap[node_pos] = temp;
                    pos = node_pos;

                }
                else break;
            }
            return return_value;
        }



    }
    public int[] topKFrequent(int[] nums, int k) {
        if (k==0) return new int[0];
        int[] ans = new int[k];
        MyBigHeap myBigHeap = new MyBigHeap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            myBigHeap.addOrLevelUp(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = myBigHeap.remove();
        }
        return ans;
    }

    public static void main(String[] args) {
        FindKMFNumbers findKMFNumbers =new FindKMFNumbers();
        System.out.println(Arrays.toString(findKMFNumbers.topKFrequent_Bucket(new int[]{1},1)));
    }
    Queue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.count-o1.count;
        }

    });
    /**
     * 执行用时 :11 ms, 在所有 Java 提交中击败了98.75%的用户
     * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了10.00%的用户
     */
    Map<Integer,Integer> n_set  = new HashMap<>();
    public int[] topKFrequent_withPriorityQueue(int[] nums, int k) {
        if (k==0) return new int[0];
        int[] ans = new int[k];

        //MyBigHeap myBigHeap = new MyBigHeap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            n_set.put(nums[i],n_set.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer,Integer> entry:n_set.entrySet()){
            heap.add(new Node(entry.getValue(),entry.getKey()));
        }
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove().val;
        }
        return ans;
    }

    class Node{
        int count;
        int val;

        public Node(int count, int val) {
            this.count = count;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node)o;
            if (val==node.val) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, val);
        }
    }

    /**
     * 执行用时 :17 ms, 在所有 Java 提交中击败了74.42%的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent_Bucket(int[] nums, int k) {
        if (k==0) return new int[0];
        int[] ans = new int[k];
        int pos =0;
        for (int i = 0; i < nums.length; i++) {
            n_set.put(nums[i],n_set.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[]bucket = new ArrayList[nums.length+1];
        for (Map.Entry<Integer,Integer> entry:n_set.entrySet()){
            if (bucket[entry.getValue()]==null) bucket[entry.getValue()] = new ArrayList<>();
            bucket[entry.getValue()].add(entry.getKey());
        }
        for (int i = bucket.length-1; i > -1; i--) {
            if (bucket[i]!=null){
                for (int j = 0; j < bucket[i].size(); j++) {
                    ans[pos++] = bucket[i].get(j);
                }
                if (pos==k) return ans;

            }
        }
        return ans;
    }
}
