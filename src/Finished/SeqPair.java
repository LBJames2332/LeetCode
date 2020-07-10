package Finished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeqPair {
    /**
     * 执行用时：59 ms, 在所有 Java 提交中击败了17.97%的用户
     * 内存消耗：58 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int val = entry.getKey();
            int peer = target - val;
            if (map.containsKey(peer)){
                while (map.get(peer)>0&&entry.getValue()>0){
                    if (peer==val){
                        while (entry.getValue()>1){
                            List<Integer> ll = new ArrayList<>();
                            ll.add(val);
                            ll.add(peer);
                            ans.add(ll);
                            entry.setValue(entry.getValue()-2);
                        }
                        break;
                    }
                    List<Integer> ll = new ArrayList<>();
                    ll.add(val);
                    ll.add(peer);
                    ans.add(ll);
                    map.put(peer,map.get(peer)-1);
                    entry.setValue(entry.getValue()-1);
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SeqPair().pairSums(new int[]{-2,-1,0,3,5,6,7,9,13,14},12));
    }
}
