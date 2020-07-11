package Finished.Powerful;

import java.util.*;

public class SmallerRightSide {
    List<Integer> ans = new ArrayList<>();
    int[] array;
    int[] val;
    int length;
    public List<Integer> countSmaller(int[] nums) {
        Map<Integer,Integer> v_pos = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i:nums){
            v_pos.put(i,0);
        }
        int pos = 1;
        for (Map.Entry<Integer,Integer> entry:v_pos.entrySet()){
            entry.setValue(pos++);
        }


        length = v_pos.size();
        array = new int[length+1];
        val = new int[nums.length];
        for (int i = nums.length-1; i > -1; i--) {
            pos = v_pos.get(nums[i]);
            increase(pos,1);
            val[i] = search(pos-1);
        }
        for (int i:val) {
            ans.add(i);
        }
        return ans;
    }

    private int search(int i) {
        int re = 0;
        while (i > 0){
            re += array[i];
            i = i - getLastBit(i);
        }
        return re;
    }

    private void increase(int i, int increment) {
        while (i <= length){
            array[i]+=increment;
            i += getLastBit(i);
        }
    }

    private int getLastBit(int i) {
        return i&((~i)+1);
    }

    public static void main(String[] args) {
        System.out.println(new SmallerRightSide().countSmaller(new int[]{3,2,4,1,2,1}));
    }
}
