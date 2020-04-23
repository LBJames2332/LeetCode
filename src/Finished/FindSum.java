package Finished;

import java.util.*;

public class FindSum {
    //找到一个数组中是否有两个数之和为target
    //不可重复使用
    //执行用时：41 ms
    //内存消耗：41.1 MB
    //https://leetcode-cn.com/problems/two-sum/
    public static void main(String[] args) {
        for (int i: twoSum(new int[]{2,5,5,11},10)){
            System.out.println(i);
        }
    }
    public static  int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        //Map<Integer,Integer> markmap = new HashMap<>();
        int[] returnArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i],l);
            }
        }
//        for(Map.Entry<Integer, List<Integer> >a:map.entrySet()){
//
//            System.out.print(a.getKey()+":");
//            for (Integer i:a.getValue()){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+" "+i);
            if (map.containsKey(target-nums[i])) {
                if (nums[i] * 2 == target) {
                    if (map.get(nums[i]).size() > 1) {
                        returnArray[0] = map.get(nums[i]).get(0);
                        returnArray[1] = map.get(nums[i]).get(1);
                        return returnArray;
                    }

                } else {
                    returnArray[0] = i;
                    returnArray[1] = map.get(nums[i]).get(0);
                    return returnArray;
                }
            }
        }
        return null;

    }
}
