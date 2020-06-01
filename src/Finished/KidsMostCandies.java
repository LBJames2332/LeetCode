package Finished;

import java.util.ArrayList;
import java.util.List;

public class KidsMostCandies {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.83%的用户
     * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int i:candies){
            max = (max>i)?max:i;
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]+extraCandies >= max) ans.add(true);
            else  ans.add(false);
        }
        return ans;
    }
}
