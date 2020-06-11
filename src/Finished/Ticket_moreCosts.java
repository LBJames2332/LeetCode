package Finished;

public class Ticket_moreCosts {
    /**
     * 执行用时 :27 ms, 在所有 Java 提交中击败了12.15%的用户
     * 内存消耗 :49.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length==0) return 0;
        int[][] dp_buffer = new int[prices.length][2];
        //o:无股票
        //1:持有股票
        dp_buffer[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_buffer[i][0] = Math.max(dp_buffer[i-1][0],dp_buffer[i-1][1]+prices[i]-fee);
            dp_buffer[i][1] = Math.max(dp_buffer[i-1][1],dp_buffer[i-1][0]-prices[i]);
        }

        return dp_buffer[prices.length-1][0];
    }

    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了99.96%的用户
     * 内存消耗 :49 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit_dp(int[] prices, int fee) {
        if (prices.length==0) return 0;
        int dp_0 = 0;
        int dp_1 = -prices[0];
        int temp;
        //o:无股票
        //1:持有股票
        for (int i = 1; i < prices.length; i++) {
            temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1+prices[i]-fee);
            dp_1 = Math.max(dp_1,temp-prices[i]);
        }

        return dp_0;
    }
}
