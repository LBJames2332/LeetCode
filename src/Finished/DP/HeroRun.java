package Finished.DP;

public class HeroRun {
    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了41.26%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dp.length-1][dp[0].length-1] = Math.max(1,1-dungeon[dp.length-1][dp[0].length-1] );
        int last_height = dp.length - 1;
        int last_kuan = dp[0].length - 1;
        for (int i = dp.length-2; i > -1; i--) {
            dp[i][last_kuan] = Math.max(dp[i+1][last_kuan]-dungeon[i][last_kuan],1);
        }
        for (int i = dp[0].length-2; i > -1; i--) {
            dp[last_height][i] = Math.max(dp[last_height][i+1]-dungeon[last_height][i],1);
        }

        for (int i = dp.length-2; i > -1; i--) {
            for (int j = dp[0].length-2; j > -1; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1);
            }
        }

        return dp[0][0];
//        boolean[][] ok_when_best = new boolean[dungeon.length][dungeon[0].length];
//        //当最优的时候是否能走，false能走，true不能走
//        for (int i = 1; i < dungeon.length; i++) {
//            if (ok_when_best[i-1][0]){
//                ok_when_best[i][0] = true;//我的来源不能走，那我也不能走
//            }
//            else {
//                dp[i][0] = dp[i-1][0]+dungeon[i][0];
//                if (dp[i][0] < 1) ok_when_best[i][0] = true;//我走了之后裂开了，我不能再走了
//            }
//        }
//        for (int i = 1; i < dungeon[0].length; i++) {
//
//            if (ok_when_best[0][i-1]){
//                ok_when_best[0][i] = true;//我的来源不能走，那我也不能走
//            }
//            else {
//                dp[0][i] = dp[0][i-1]+dungeon[0][i];
//                if (dp[0][i] < 1) ok_when_best[0][i] = true;//我走了之后裂开了，我不能再走了
//            }
//        }
//        for (int i = 1; i < dungeon.length; i++) {
//            for (int j = 1; j < dungeon[i].length; j++) {
//                int max = 0;
//                if (!ok_when_best[i-1][j]){
//                    max = Math.max(max,dp[i-1][j]);
//                }
//                if (!ok_when_best[i][j-1]){
//                    max = Math.max(max,dp[i][j-1]);
//                }
//                if (max < 1){
//                    //两个都不能走的情况
//                    //因为若有false的则必然是一个正值
//                    ok_when_best[i][i] = true;
//                }
//                else {
//                    dp[i][j] = max+dungeon[i][j];
//                    if (dp[i][j] < 1) ok_when_best[i][j] = true;//我走了之后裂开了，我不能再走了
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println(new HeroRun().calculateMinimumHP(new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        }));
    }


}
