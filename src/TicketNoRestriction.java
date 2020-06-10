public class TicketNoRestriction {
    public int maxProfit(int[] prices) {
        if (prices.length==1) return 0;
        if (prices.length==2) return Math.max(0,prices[1]-prices[0]);
        int[][]dp_buffer = new int[prices.length][2];
        dp_buffer[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_buffer[i][0] = Math.max(dp_buffer[i-1][1]+prices[i],dp_buffer[i-1][0]);
            dp_buffer[i][1] = Math.max(dp_buffer[i-1][0]-prices[i],dp_buffer[i-1][1]);
        }
        return dp_buffer[prices.length-1][0];

    }

    public static void main(String[] args) {
        System.out.println(new TicketNoRestriction().maxProfit(new int[]{7,6,4,3,1}));
    }
}
