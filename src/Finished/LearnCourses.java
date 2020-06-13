package Finished;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LearnCourses {
    /**
     * 执行用时 :9 ms, 在所有 Java 提交中击败了43.12%的用户
     * 内存消耗 :40.6 MB, 在所有 Java 提交中击败了90.00%的用户
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int d_i[] = new int[numCourses];
        List<Integer> l_o[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            l_o[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            d_i[prerequisites[i][0]]++;
            l_o[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < numCourses; i++) {
            if (d_i[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            for (int i:l_o[queue.poll()]){
                System.out.println(queue.size());
                d_i[i]--;
                if (d_i[i]==0)queue.add(i);
            }
        }
        if (count==numCourses) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LearnCourses().canFinish(4,new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {1,3}}));
    }

}
