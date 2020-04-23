package Finished;

public class WaysToSmallChange {
    /**
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     * 执行用时 :102 ms, 在所有 Java 提交中击败了6.85%的用户
     * 内存消耗 :135.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param
     * @return
     */
    public static void main(String[] args) {
        System.out.println(waysToChange(900750));
    }
    public static int waysToChange(int n) {
        long[][] target_min = new long[n+1][4];
        int[]type = new int[4];
        type[0] = 1;
        type[1] = 5;
        type[2] = 10;
        type[3] = 25;
        for (int i = 1; i < n+1;i++){
            if (i < type[0]) target_min[i][0]=0;
            if (i < type[1]) target_min[i][1]=0;
            if (i < type[2]) target_min[i][2]=0;
            if (i < type[3]) target_min[i][3]=0;
            if (i == type[0]) target_min[i][0]=1;
            if (i == type[1]) target_min[i][1]=1;
            if (i == type[2]) target_min[i][2]=1;
            if (i == type[3]) target_min[i][3]=1;

        }
        for (int i = 2; i < n+1; i++) {
            if (i > 1){
                target_min[i][0] = target_min[i-1][0]+target_min[i-1][1]+target_min[i-1][2]+target_min[i-1][3];
            }
            if (i >5){
                target_min[i][1] = target_min[i-5][1]+target_min[i-5][2]+target_min[i-5][3];
            }
            if (i >10){
                target_min[i][2] = target_min[i-10][2]+target_min[i-10][3];
            }if (i >25){
                target_min[i][3] = target_min[i-25][3];
            }
            //System.out.println(i+ " "+(target_min[i][0])+" "+(target_min[i][1])+" "+(target_min[i][2])+" "+(target_min[i][3]));
        }
        return (int) ((target_min[n][0]+target_min[n][1]+target_min[n][2]+target_min[n][3])%1000000007);
    }
    /**
     *      public static int waysToChange(int n) {
     *         int[] N_way = new int[n+1];
     *         N_way[0] = 1;
     *         if (n>1){
     *             N_way[1] = 1;
     *         }
     *         int[]type = new  int[4];
     *         type[0] = 1;
     *         type[1] = 5;
     *         type[2] = 10;
     *         type[3] = 25;
     *         for (int i = 2; i < n+1; i++) {
     *             N_way[i] = NMin(i-1,0,type)+NMin(i-5,1,type)+NMin(i-10,2,type)+NMin(i-25,3,type);
     *         }
     *         for (int i = 1; i < n+1; i++) {
     *             System.out.println(N_way[i]);
     *         }
     *         return 0;
     *     }
     *     public static int NMin(int target,int min_pos,int[]type){
     *
     *         if (target < type[min_pos]){
     *             return 0;
     *         }
     *
     *         if (target==min_pos||target==0) return 1;
     *         else {
     *             int count = 0;
     *             for (int i = min_pos; i < type.length; i++) {
     *                 count += NMin(target-type[i],i,type);
     *             }
     *             return count;
     *         }
     *     }
     */
}
