package Finished;

import java.util.Scanner;

public class CompleteSquare {
    /**
     * 执行用时 :946 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了10.53%的用户
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(numSquares(sc.nextInt()));
        }
    }
    public static int numSquares(int n) {
        int[] mark = new int[n + 1];
        int[] s = new int[n + 1];
        int next = 1;
        for (int i = 1; i < n + 1; i++) {
            //求最大平方根
            for (int j = next; j < n; j++) {
                if (j * j > i) {
                    s[i] = j - 1;
                    next = s[i];
                    break;
                }
                else if (j * j == i) {
                    mark[i] = 1;
                    s[i] = j;
                    next = j;
                    break;
                }

            }
        }
        int[] pow = new int[s[n]+1];
        for (int i = 1; i <= s[n]; i++) {
            pow[i] = i*i;
        }
        for (int i = 2; i < n+1; i++) {
            if (mark[i]!=1){
                int min = 1+mark[i-1];
                for (int j = 2; j <= s[i]; j++) {
                    if (min > 1+mark[i-pow[j]]) {
                        min = 1+mark[i-pow[j]];
                    }

                }
                mark[i] = min;
            }

        }

        return mark[n];
    }
}