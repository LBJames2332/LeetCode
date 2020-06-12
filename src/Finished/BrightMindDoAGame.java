package Finished;

public class BrightMindDoAGame {
    int[] P;

    /**
     * 执行用时 :30 ms, 在所有 Java 提交中击败了12.82%的用户
     * 内存消耗 :42.1 MB, 在所有 Java 提交中击败了8.33%的用户
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        P = piles;
        int my = pre(0,piles.length-1);
        int he = post(0,piles.length-1);

        return my>he?true:false;
    }
    private int pre(int start, int end){
        if (start==end) return P[start];
        return Math.max(P[start]+post(start+1,end),P[end]+post(start,end-1));
    }
    private int post(int start, int end){
        if (start==end) return 0;
        return Math.min(pre(start,end-1),pre(start+1,end));
    }

    public static void main(String[] args) {
        System.out.println(new BrightMindDoAGame().stoneGame_2(new int[]{5,3,4,5}));
    }


    int[][] pre;
    int[][] post;
    public boolean stoneGame_2(int[] piles) {
        pre = new int[piles.length][piles.length];
        post = new int[piles.length][piles.length];
        P = piles;
        int my = pre_2(0,piles.length-1);
        int he = post_2(0,piles.length-1);
        System.out.println(my+" "+he);

        return my>he?true:false;
    }
    private int pre_2(int start, int end){
        if (pre[start][end]!=0) return pre[start][end];
        if (start==end) {
            pre[start][end] = P[start];
            return P[start];
        }
        pre[start][end] = Math.max(P[start]+post_2(start+1,end),P[end]+post_2(start,end-1));
        return pre[start][end];
    }
    private int post_2(int start, int end){
        if (post[start][end]!=0) return post[start][end];
        if (start==end) {
            post[start][end] = 0;
            return 0;
        }
        post[start][end] = Math.min(pre_2(start,end-1),pre_2(start+1,end));
        return post[start][end];
    }
}
