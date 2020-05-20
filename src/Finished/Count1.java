package Finished;

import java.util.Arrays;

public class Count1 {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了39.95%的用户
     * 内存消耗 :43.9 MB, 在所有 Java 提交中击败了5.88%的用户
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] ans = new int[num+1];
        ans[0] = 0; //ans[1] = 1;
        int N2 = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < N2; j++) {
                if (i==num+1) break;
                ans[i] = ans[(i++)-N2]+1;
            }
            N2 <<= 1;
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Count1 count1 = new Count1();
        System.out.println(Arrays.toString(count1.countBits(18)));
    }
}
