package Finished.DP;

public class SealTicketk2 {
    int with_1=Integer.MIN_VALUE;
    int without_1;
    int with_2=Integer.MIN_VALUE;
    int without_2;

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了93.33%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了57.14%的用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        for (int p:prices) {
            without_2 = Math.max(without_2,with_2+p);
            with_2 = Math.max(with_2,without_1-p);
            without_1 = Math.max(without_1,with_1+p);
            with_1 = Math.max(with_1,-p);
        }
        return Math.max(without_1,without_2);
    }

    public static void main(String[] args) {
        System.out.println(new SealTicketk2().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
