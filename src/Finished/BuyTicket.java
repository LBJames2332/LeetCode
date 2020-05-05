package Finished;

public class BuyTicket {
    /**
     * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
     * 火车票有三种不同的销售方式：
     * 一张为期一天的通行证售价为 costs[0] 美元；
     * 一张为期七天的通行证售价为 costs[1] 美元；
     * 一张为期三十天的通行证售价为 costs[2] 美元。
     * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
     * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
     *
     * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了47.15%的用户
     * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days[days.length - 1]+1];
        System.out.println(dp.length);
        int cost;
        int curr = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i < days[curr]){
                dp[i] = dp[i - 1];
            }
            else {
                curr++;
                cost = Integer.MAX_VALUE;
                cost = (cost < (getValue(dp,i-1) + costs[0]))?cost:(getValue(dp,i-1) + costs[0]);
                cost = (cost < (getValue(dp,i-7) + costs[1]))?cost:(getValue(dp,i-7) + costs[1]);
                cost = (cost < (getValue(dp,i-30) + costs[2]))?cost:(getValue(dp,i-30) + costs[2]);
                dp[i] = cost;
            }

        }
        return dp[dp.length - 1];
    }
    public int getValue(int[] arr,int pos){
        if (pos < 0) return 0;
        else return arr[pos];
    }

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        System.out.println(buyTicket.mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15}));
    }
}
