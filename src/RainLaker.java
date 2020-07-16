import java.util.*;

public class RainLaker {
    /**
     * 执行用时：160 ms, 在所有 Java 提交中击败了30.61%的用户
     * 内存消耗：57.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> set = new HashMap<>();
        List<Integer> zero = new ArrayList<>();
        int[] ans = new int[rains.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = 1;
        }
        for (int i = 0; i < rains.length; i++) {
            if (rains[i]==0){
                zero.add(i);
            }
            else {
                if (set.containsKey(rains[i])){
                    //如果前面这个湖满了
                    //则在zero里面找一个在前一个这个湖下雨的后面的最近的一个不下雨的天来放这个湖的水
                    int from = set.get(rains[i]);
                    boolean find = false;
                    for (int j = 0; j < zero.size(); j++) {
                        if (zero.get(j)>from){
                            ans[zero.get(j)] = rains[i];//找到的这一天拿来排rains[i]的水
                            find = true;
                            zero.remove(j);
                            break;
                        }
                    }
                    if (!find) return new int[0];
                }
                ans[i] = -1;
                set.put(rains[i],i);
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RainLaker().avoidFlood(new int[]{69,0,0,0,69})));
    }
}
