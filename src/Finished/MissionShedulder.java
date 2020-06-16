package Finished;

import java.util.Arrays;

public class MissionShedulder {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.85%的用户
     * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了11.11%的用户
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c:tasks){
            count[c-'A']++;
        }
        Arrays.sort(count);
        System.out.println(Arrays.toString(count));
        int max_value = count[25]-1;
        int ide_space = max_value*n;
        for (int i = 25; i >=0&&count[i]>0 ; i--) {
            ide_space -= Math.min(max_value,count[i]);
        }
        return ide_space>0?ide_space+tasks.length:tasks.length;

    }

    public static void main(String[] args) {
        new MissionShedulder().leastInterval(new char[]{'A','B','C','A','A','C'},5);
    }
}
