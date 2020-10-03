public class Leaves {

    int[][] dp;
    boolean[][] mark;
    char[] leaveChars;
    //leetcode LCP 19
    /**
     * 将叶子调整为R..Y..R..的形式的最少变化次数
     */
    //分析：其实叶子只有三种情况(首段R的叶子(0)、中段Y的叶子(1)、末段R的叶子(2))
    public int minimumOperations(String leaves) {
        leaveChars = leaves.toCharArray();
        dp = new int[leaves.length()][3];
        mark = new boolean[leaves.length()][3];
        mark[0][1] = true;
        mark[0][2] = true;
        mark[0][0] = true;
        dp[0][0] = leaveChars[0]=='r'?0:1;
        dp[0][1] = leaveChars.length;
        dp[0][2] = leaveChars.length;
        return calAt(leaveChars.length - 1,2);
    }

    private int calAt(int i, int j) {
        if (mark[i][j]) return dp[i][j];

        if (j == 0) dp[i][j] = ((leaveChars[i]=='r')?0:1)+calAt(i-1,0);
            //i位置的叶子已经是第一段的红色叶子了，其前面全部得为第一段的红色叶子

        else if (j == 1) dp[i][j] = ((leaveChars[i]=='y')?0:1)+Math.min(calAt(i-1,0), calAt(i-1,1));

        else {
            dp[i][j] = ((leaveChars[i]=='r')?0:1)+Math.min(calAt(i-1,2), calAt(i-1,1));
        }

        mark[i][j] = true;

        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Leaves().minimumOperations("ryr"));
    }
}
