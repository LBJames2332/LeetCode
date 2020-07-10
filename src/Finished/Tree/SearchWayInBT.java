package Finished.Tree;

import java.util.ArrayList;
import java.util.List;

public class SearchWayInBT {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        int log = (int)(Math.log(label)/Math.log(2));
//        int[] mi = new int[log+1];
//        mi[0] = 1;
//        for (int i = 1; i < mi.length; i++) {
//            mi[i] = mi[i - 1]<<1;
//        }
        List<Integer> ans = new ArrayList<>(log+1);
        for (int i = 0; i <= log; i++) {
            ans.add(0);
        }
        ans.set(log,label);
        for (int i = log-1; i > -1 ; i--) {
            label /= 2;//减半
            int sum_of_level = (1<<i) + (1<<(i+1)) - 1;
            label = sum_of_level-label;
            ans.set(i,label);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((int)(Math.log(26)/Math.log(2)));
        System.out.println(new SearchWayInBT().pathInZigZagTree(26));

    }
}
