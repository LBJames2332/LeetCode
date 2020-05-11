package Finished;

public class Pow {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了94.50%的用户
     * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了5.88%的用户
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x==0) return 0.0;
        if (n==0) return 1.0;
        long b = n;
        if (n < 0){
            b = -b;
            x =1/x;
        }
        double ans = 1;
        while (b!=0){
            if ((b&1)==1){
                ans*=x;
            }
            x*=x;
            b>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2,-1));
    }
}