package Finished;

import java.util.*;


public class ClassSchedule {
    Map<Integer, List<Integer>> map = new HashMap<>();

    Set<Integer> set = new HashSet<>();
    boolean[] circle;
    int[] ans;
    int ans_size = 0;

    /**
     * 执行用时 :13 ms, 在所有 Java 提交中击败了43.80%的用户
     * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了93.33%的用户
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new int[numCourses];
        circle = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> help_reference = map.getOrDefault(prerequisites[i][0],new ArrayList<>());
            help_reference.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],help_reference);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!check(i)) return new int[0];
        }
        return ans;
    }

    private boolean check(int i) {
        if (set.contains(i)) return true;
        boolean return_value;
        if (!map.containsKey(i)) {
            set.add(i);
            ans[ans_size++] = i;
            return true;
        }
        else {
            circle[i] = true;
            return_value = DFS(i);
            circle[i] = false;
            if (!return_value) return false;
            if (!set.contains(i)) {
                set.add(i);
                ans[ans_size++] = i;
            }
        }
        return true;
    }

    private boolean DFS(int i) {
        int help;
        boolean return_value;
        for (int j = 0; j < map.get(i).size(); j++) {
            help = map.get(i).get(j);
            if (!map.containsKey(help)){
                if (!set.contains(help)) {
                    set.add(help);
                    ans[ans_size++] = help;
                }
            }
            else {
                if (circle[help]) return false;
                circle[help] = true;
                return_value = DFS(help);
                circle[help] = false;
                if (!return_value) return false;
                if (!set.contains(help)) {
                    set.add(help);
                    ans[ans_size++] = help;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ClassSchedule classSchedule = new ClassSchedule();
        System.out.println(Arrays.toString(classSchedule.findOrder(4
                , new int[][]{{0,1},{1,2},{0,3},{3,0}})));
    }
}

