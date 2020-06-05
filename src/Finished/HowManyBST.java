package Finished;

public class HowManyBST {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了7.69%的用户
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n<2) return 1;
        int[]G = new int[n+1];
        G[0] =1;
        G[1] =1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
