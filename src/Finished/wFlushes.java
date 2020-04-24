package Finished;

import java.util.Map;
import java.util.TreeMap;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 如果她可以完成分组就返回 true，否则返回 false。
 * https://leetcode-cn.com/problems/hand-of-straights
 *
 * 执行用时 :88 ms, 在所有 Java 提交中击败了29.74%的用户
 * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了25.00%的用户
 */
public class wFlushes {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{ 1,2,3,6,2,3,4,7,8},3));
    }
    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W!=0) return false;
        Map<Integer,Integer> t_map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            t_map.put(hand[i], t_map.getOrDefault(hand[i],0)+1);
        }
        for (int i:t_map.keySet()){
            if (t_map.get(i) > 0) {
                for (int j = 1; j < W; j++) {
                    //if(!t_map.containsKey(i+j)) return false;
                    if (t_map.getOrDefault(i+j,0) < t_map.get(i)){
                        return false;
                    }
                    t_map.put(i+j,t_map.get(i+j)- t_map.get(i));
                }
            }
        }
        return true;
    }
}
