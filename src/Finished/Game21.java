package Finished;

public class Game21 {
    int k;
    int w;
    int n;

    /**
     * 记忆化搜索
     */
    double[] memo;
    int sum2;
    int all2;
    public double new21Game_memo(int N, int K, int W) {
        k = K;
        w = W;
        n = N;
        memo = new double[K+W];

        return process_memo(0);
    }
    private double process_memo(int cur){
        if (cur >= k) {
            all2++;
            if (cur<=n) {
                sum2++;
                return 1;
            }
            return 0;
        }
        if (memo[cur]!=0) return memo[cur];
        double count = 0;
        for (int i = 1; i <= w; i++) {
            count += process_memo(cur+i);
        }
        memo[cur] = count/w;
        return memo[cur];
    }


    /**
     * 优化动态规划
     * 执行用时 :4 ms, 在所有 Java 提交中击败了96.23%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    double[] dp_buffer;
    public double new21Game_dp(int N, int K, int W) {
        if(W==0) return (K==0)?1:0;
        if(K==0) return 1;
        if (N >= W+K) return 0;
        dp_buffer = new double[N+1];
        dp_buffer[0] = 1d;
        dp_buffer[1] = (double) 1/W;
        int first_pos = Math.min(W,K);

        for (int i = 2; i <= first_pos; i++) {
            dp_buffer[i] = dp_buffer[i-1]+ dp_buffer[i-1]/W;
        }
        if (K < W){
            int second_pos = Math.min(W,N);
            for (int i = first_pos+1; i <= second_pos; i++) dp_buffer[i] = dp_buffer[i -1];
            if (N == second_pos) {
                double sum = 0;
                for (int i = K; i <= N; i++) sum += dp_buffer[i];
                return sum;
            }
            for (int i = second_pos+1; i <= N; i++) {

                dp_buffer[i] = dp_buffer[i - 1] - dp_buffer[i - W - 1] / W;
            }

        }
        else {
            for (int i = first_pos+1; i <= K ; i++) dp_buffer[i] = dp_buffer[i-1] + (dp_buffer[i-1]-dp_buffer[i-W-1])/W;
            for (int i = K+1; i <= N; i++) dp_buffer[i] = dp_buffer[i -1]- dp_buffer[i-W-1]/W;
        }

        double sum = 0;
        for (int i = K; i <= N; i++) sum += dp_buffer[i];
        return sum;
    }



    public static void main(String[] args) {
        Game21 game21 = new Game21();
        System.out.println(game21.new21Game_dp(21,17,10));
    }
}
