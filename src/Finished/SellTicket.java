package Finished;

public class SellTicket {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.81%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了5.32%的用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
             max = Math.max(max,prices[i]-min);
             min = (min < prices[i])?min:prices[i];
        }
        return max;
    }
}
