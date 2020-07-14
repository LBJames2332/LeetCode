package Finished.Powerful;

import java.util.*;

public class LastUseLessEdge {
    Set<Integer> set = new HashSet<>();

    class N{
        int val;
        int pos;

        public N(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
    Map<Integer,List<N>> f_pos;

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了20.27%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection_Map(int[][] edges) {
        //init
        f_pos = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (f_pos.containsKey(edges[i][1])){
                f_pos.get(edges[i][1]).add(new N(edges[i][0],i));
            }
            else {
                List<N> ll = new ArrayList<>(1);
                ll.add(new N(edges[i][0],i));
                f_pos.put(edges[i][1],ll);
            }
        }





        for (Map.Entry<Integer,List<N>> entry:f_pos.entrySet()){
            if (entry.getValue().size()==2) {
                //从两个边出发
                //若两边找父都无法找到自己则返回两边老的一条
                //若有一条能找到，则返回另一条
                N n1 = f_pos.get(entry.getKey()).get(0);
                N n2 = f_pos.get(entry.getKey()).get(1);

                int max = -1;

                int inv = entry.getKey();

                if (checkIsLoop(inv,inv)){
                    return edges[n1.pos];
                }

                max = Math.max(max,n1.pos);
                if (checkIsLoop(inv,inv)){
                    return edges[n2.pos];
                }

                max = Math.max(max,n2.pos);
                return edges[max];


            }
        }
        //没有入度为2的
        set.add(edges[0][0]);
        int inv = getInVertex(edges[0][0]);
        int son = inv;
        int f;
        int max = -1;
        do{
            N n =f_pos.get(son).get(0);
            f = n.val;
            max = Math.max(max,n.pos);
            son = f;
        }while (f!=inv);
        return edges[max];
    }

    private boolean checkIsLoop(int son, int inv) {
        do {//遍历环
            if (!f_pos.containsKey(son)) {
                //不能找到inv，说明
                return false;
            }
            son = f_pos.get(son).get(0).val;
        }while (son!=inv);
        return true;
    }

    //获得从i回溯找到的环的入射点
    private int getInVertex(int i) {
        if (set.contains(i)) return i;
        set.add(i);
        return getInVertex(f_pos.get(i).get(0).val);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new LastUseLessEdge().findRedundantDirectedConnection_Map(new int[][]{
                        {1,2}, {2,3}, {3,4},{4,1},{1,5}
                })));
        ;
    }
}
