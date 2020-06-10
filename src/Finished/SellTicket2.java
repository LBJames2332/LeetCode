package Finished;

public class SellTicket2 {
    int[] P;
    int max;
    int[][]dp_buffer;
    public int maxProfit(int[] prices) {
        P = prices;
        process(0,0,0);
        return max;
    }

    /**
     *
     * @param index
     * @param whatodo 现在可以做的事情（0：买入，1：售出）
     * //@param prevLine 前一个售出股票的时间节点(必须差值为2才可购入)
     *
     */
    private void process(int index,int whatodo,int money){
        if (index >= P.length){ //BaseCase
            if(whatodo==0) {
                max = (max>money)?max:money;
            }
            return;
        }
        if (whatodo==1){
            process(index+2,0,money+P[index]);
            process(index+1,1,money);
        }
        else {
            process(index+1,1,money-P[index]);
            process(index+1,0,money);
        }
    }
    public int maxProfit_dp(int[] prices) {
        if (prices.length<2) return 0;
        dp_buffer = new int[prices.length][2];
        dp_buffer[0][0] = -prices[0];
        dp_buffer[1][0] = -Math.min(prices[0],prices[1]);
        dp_buffer[1][1] = Math.max(0,prices[1]-prices[0]);
        for (int i = 2; i < prices.length; i++) {
            dp_buffer[i][0] = Math.max(dp_buffer[i-2][1]-prices[i],dp_buffer[i-1][0]);
            dp_buffer[i][1] = Math.max(dp_buffer[i-1][0]+prices[i],dp_buffer[i-1][1]);
        }
        return dp_buffer[prices.length-1][1];
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.19%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param prices
     * @return
     */
    public int maxProfit_dp1(int[] prices) {
        if (prices.length<2) return 0;
        int dp1_1 = Math.max(0,prices[1]-prices[0]);
        int dp1_2 = 0;
        int dp0_1 = -Math.min(prices[0],prices[1]);
        int temp;
        for (int i = 2; i < prices.length; i++) {
            temp = dp0_1;
            dp0_1 = Math.max(dp1_2-prices[i],dp0_1);
            dp1_2 = dp1_1;
            dp1_1 = Math.max(temp+prices[i],dp1_1);
        }
        return dp1_1;
    }
    /**
     *
     * @param index
     * @param whatodo 现在可以做的事情（0：买入，1：售出）
     * //@param prevLine 前一个售出股票的时间节点(必须差值为2才可购入)
     *
     */
    private void process_dp(int index,int whatodo,int money){
        if (index >= P.length){ //BaseCase
            if(whatodo==0) {
                max = (max>money)?max:money;
            }
            return;
        }
        if (whatodo==1){
            process(index+2,0,money+P[index]);
            process(index+1,1,money);
        }
        else {
            process(index+1,1,money-P[index]);
            process(index+1,0,money);
        }
    }
    public static void main(String[] args) {
        System.out.println(new SellTicket2().maxProfit_dp1(new int[]{1,2,3,0,2}));
    }
}
