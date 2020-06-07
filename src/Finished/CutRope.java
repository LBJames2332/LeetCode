package Finished;

public class CutRope {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n<=3) return n-1;
        int b = n%3;
        if (b==0) return (int) Math.pow(3,n/3);
        else if (b==1) return (int) (Math.pow(3,n/3-1)*4);
        else return (int) (Math.pow(3,n/3)*2);
    }
}
