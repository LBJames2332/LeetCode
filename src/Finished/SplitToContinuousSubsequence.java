package Finished;

import java.util.HashMap;

public class SplitToContinuousSubsequence {
    /**
     * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
     * @param nums
     * @return
     */
//    int prev;
//    int start;
//    int[] N;
//    public boolean isPossible(int[] nums) {
//        prev = nums[0];
//        start = nums[0];
//        N = nums;
//        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
//        //HashMap<Integer, Node> tail = new HashMap<>();//以key为末尾的所有连续子序列的尾部节点地址
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i] - 1)&&map.get(nums[i] - 1).size() > 0){
//                if (!map.containsKey(nums[i])){
//                    Stack<Integer> stack = new Stack<>();
//                    stack.add(map.get(nums[i] - 1).pop() + 1);
//                    map.put(nums[i],stack);
//                }
//                else {
//                    map.get(nums[i]).add(map.get(nums[i] - 1).pop() + 1);
//
//                }
//                if (map.get(nums[i] - 1).size() == 0) map.remove(nums[i] - 1);
//                prev = nums[i];
//            }
//            else {
//                //没有以比他小1的值为末端的连续子序列
//                if (judge(map)){//判断分割点之前是否ok
//                    //另起一个新序列
//                    start = prev;
//                    if (!map.containsKey(nums[i])){
//                        Stack<Integer> stack = new Stack<>();
//                        stack.add(1);
//                        map.put(nums[i],stack);
//                    }
//                    else {
//
//                        map.get(nums[i]).add(1);
//                    }
//                    prev = nums[i];
//                }
//                else return false;
//            }
//        }
//        while (!map.get(nums[nums.length - 1]).empty()) {
//            System.out.println(map.get(nums[nums.length - 1]).peek());
//            if (map.get(nums[nums.length - 1]).pop() < 3) return false;
//        }
//        return judge(map);
//    }
//
//    private boolean judge(HashMap<Integer, Stack<Integer>> map) {
//        System.out.println("----------------------");
//        System.out.println(start+"  "+prev);
//        for (int i = prev - 1; i >= start; i--) {
//            System.out.println(i);
//            if (map.containsKey(i)) {
//                System.out.println(map.get(i).size()+",size");
//                while (!map.get(i).empty()) {
//                    System.out.println(map.get(i).peek());
//                    if (map.get(i).pop() < 3) return false;
//                }
//                map.remove(i);
//            }
//        }
//        System.out.println("---------------------");
//        return true;
//    }

    /**
     * 执行用时 :35 ms, 在所有 Java 提交中击败了52.13%的用户
     * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();//统计元素个数
        for (int i:nums) {
            count.put(i,count.getOrDefault(i,0)+1);
        }
        HashMap<Integer, Integer> tail = new HashMap<>();//统计想要以key为结尾的实链的个数
        for (int i:nums) {
            if (count.get(i) == 0) {
                continue;
            }
            else {
                if (tail.getOrDefault(i,0) > 0) {
                    tail.put(i, tail.get(i) - 1);
                    tail.put(i + 1, tail.getOrDefault(i + 1, 0) + 1);
                } else {
                    if (count.get(i + 1) > 0 && count.get(i + 1) > 0) {
                        count.put(i + 1, count.get(i + 1) - 1);
                        count.put(i + 2, count.get(i + 2) - 1);
                        tail.put(i + 3, tail.getOrDefault(i + 3, 0) + 1);
                    } else return false;
                }
                count.put(i, count.get(i) - 1);
            }

        }
        return true;
    }
    public static void main(String[] args) {
        SplitToContinuousSubsequence splitToContinuousSubsequence = new SplitToContinuousSubsequence();
        System.out.println(splitToContinuousSubsequence.isPossible(new int[]{1,2,3,3,4,5}));
    }
}
