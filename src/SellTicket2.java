public class SellTicket2 {
    int[] P;
    int max;
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

    public static void main(String[] args) {
        System.out.println(new SellTicket2().maxProfit(new int[]{1,2,3,0,2}));
    }
}
