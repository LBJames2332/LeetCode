package Finished;

import java.util.*;

public class Union {
    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了57.08%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了5.13%的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> set = new HashMap();
        List<Integer> ans = new ArrayList<>();

        for(int i:nums1){
            set.put(i,set.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            if(set.containsKey(i)&&set.get(i)>0) {
                ans.add(i);
                set.put(i,set.get(i)-1);
            }
        }
        int[] answer = new int[ans.size()];
        int index = 0;
        for (int i:ans){
            answer[index++] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Union().intersect(new int[]{1,2,2,1}, new int[]{2,2})));
    }
}
