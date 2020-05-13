package Finished;

import java.util.HashSet;
import java.util.Set;

public class LongestFibonacciSS {
    /**
     * 执行用时 :94 ms, 在所有 Java 提交中击败了67.26%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        if (A.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        int max = 1;
        int legth = 0;
        int a,b,c,help;
        for (int i = 0; i < A.length-legth; i++) {
            a = A[i];
            for (int j = i+1; j < A.length-legth; j++) {
                b = A[j];
                legth = 2;
                c = a+b;
                while (set.contains(c)){
                    legth++;
                    help = b;
                    b = c;
                    c = c+help;
                }
                max = max>legth?max:legth;
            }

        }
        return max<2?0:max;
    }

    public static void main(String[] args) {
        LongestFibonacciSS longestFibonacciSS = new LongestFibonacciSS();
        System.out.println(longestFibonacciSS.lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
    }
}
