package Finished;

public class CountSStrMutiK {
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了91.32%的用户
     * 内存消耗 :43 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int sum = 0;
        int help;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            help = (sum%K+K)%K;
            ans += map[help];
            map[help]++;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-8%6);
        CountSStrMutiK countSStrMutiK = new CountSStrMutiK();
        System.out.println(countSStrMutiK.subarraysDivByK(new int[]{-1,2,9},2));
    }
}
