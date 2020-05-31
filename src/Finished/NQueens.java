package Finished;

public class NQueens {
    int count = 0;
    int limit;

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了16.67%的用户
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        limit = (n==32)?-1:((1<<n)-1);//变成一个可选位置都为1，不可选位置都为0的数字
        process(0,0,0);
        return count;
    }

    /**
     *
     * @param collimit:列限制，当前列被选定的置为1
     * @param leftlimit：左限制：当前行在任何情况下的左斜对角线上的位置置为1
     * @param rightlimit：右限制：当前行在任何情况下的右斜对角线上的位置置为1
     */
    private void process(int collimit, int leftlimit, int rightlimit) {
        if (collimit==limit) {//base case
            count++;
            return;
        }
        int pos = limit&(~ (collimit | leftlimit | rightlimit) );
        int rightest;
        while (pos!=0){
            rightest = pos&(~pos+1);
            pos -= rightest;
            process(collimit|rightest
                    ,(leftlimit|rightest)<<1
                    ,(rightlimit|rightest)>>>1);
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.totalNQueens(4));
    }
}
