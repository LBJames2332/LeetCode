public class Sum {

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param n
     * @return
     */
    public int sumNums(int n) {
        int ans = 0;
        int A = n+1;
        int rightest = n&(~n+1);
        boolean flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;

        rightest = n&(~n+1);
        flag = (n!=0)&& (ans += A<<(Integer.toBinaryString(rightest).length()-1))>0;
        n -= rightest;
        return ans>>1;
    }



    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.sumNums(100));
    }
}
