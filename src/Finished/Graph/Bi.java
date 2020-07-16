package Finished.Graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Bi {
    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了6.18%的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败75.00%的用户
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            set.add(i);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        while (!set.isEmpty()){
            Iterator<Integer> it = set.iterator();
            int value = it.next();
            queue.add(value);
            map.put(value,0);
            System.out.println(value);
            it.remove();
            while (!queue.isEmpty()){
                int val = queue.poll();
                int pos = map.get(val);
                int peer_pos = pos^1;
                for (int i: graph[val]){
                    if (map.containsKey(i)){
                        if (map.get(i)==pos) return false;
                    }
                    else {
                        map.put(i,peer_pos);
                        set.remove(i);
                        queue.add(i);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Bi().isBipartite(new int[][]{
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        }));
    }
}
