import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPaths {
    public List<List<Integer>> ans = new ArrayList<>();
    public int[][] G;

    /**
     * 执行用时：12 ms, 在所有 Java 提交中击败了5.52%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        G = graph;
        List<Integer> ll = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        ll.add(0);
        set.add(0);
        tryAll(set, ll,0);
        return ans;
    }
    private void tryAll(Set<Integer> set,List<Integer> ll, int index){
        for (int i:G[index]){
            if (!set.contains(i)){
                List<Integer> lls = new ArrayList<>(ll);
                lls.add(i);
                if (i==G.length-1) ans.add(lls);
                else {
                    Set<Integer> sets = new HashSet<>(set);
                    sets.add(i);
                    tryAll(sets,lls,i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllPaths().allPathsSourceTarget(new int[][]{
                {1,2},{3},{3},{}
        }));
    }
}
