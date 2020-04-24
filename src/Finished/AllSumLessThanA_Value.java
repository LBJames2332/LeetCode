package Finished;

import java.util.*;

public class AllSumLessThanA_Value {
    /**
     * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
     * 返回值小于或等于 bound 的所有强整数组成的列表。
     * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
     * 执行用时 :2756 ms
     * 内存消耗 :40.4 MB
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2,3,10));
    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> ans_s = new HashSet<>();
        long mark;
        long v1;
        long v2;
        for(int i = 0;i <= bound;i++){
            for(int j = 0;j <= bound;j++){
                v1 = (long)Math.pow(x,i);
                v2 = (long)Math.pow(y,j);
                if (v1>bound||v2>bound){
                    break;
                }
                mark = v1+v2;
                if(mark <= bound) {
                    if(!ans_s.contains((int)mark)){
                        ans_s.add((int)mark);
                        ans.add((int)mark);
                    }
                }
            }
        }
        return ans;
    }
}
