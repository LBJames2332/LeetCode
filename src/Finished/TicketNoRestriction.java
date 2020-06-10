package Finished;

public class TicketNoRestriction {
    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了10.99%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length==1) return 0;
        int[][]dp_buffer = new int[prices.length][2];
        dp_buffer[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_buffer[i][0] = Math.max(dp_buffer[i-1][1]+prices[i],dp_buffer[i-1][0]);
            dp_buffer[i][1] = Math.max(dp_buffer[i-1][0]-prices[i],dp_buffer[i-1][1]);
        }
        return dp_buffer[prices.length-1][0];

    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了26.81%的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了6.25%的用户
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        if (prices.length==1) return 0;
        int dp_0=0;
        int dp_1 = -prices[0];
        int temp;
        for (int i = 1; i < prices.length; i++) {
            temp = dp_0;
            dp_0 = Math.max(dp_1+prices[i],temp);
            dp_1 = Math.max(temp-prices[i],dp_1);
        }
        return dp_0;

    }

    public static void main(String[] args) {
        System.out.println(new TicketNoRestriction().maxProfit(new int[]{7,6,4,3,1}));
    }
}
