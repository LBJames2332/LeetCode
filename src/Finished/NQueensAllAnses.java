package Finished;

import java.util.ArrayList;
import java.util.List;

public class NQueensAllAnses {
    int count = 0;
    int limit;
    int[]save;
    public List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        limit = (n==32)?-1:((1<<n)-1);//变成一个可选位置都为1，不可选位置都为0的数字
        save = new int[n];
        process2(0,0,0,0);
        return ans;
    }
    private void process2(int index, int collimit, int leftlimit, int rightlimit) {
        if (collimit==limit) {//base case
            List<String> ss = new ArrayList<>();
            for (int i = 0; i < save.length; i++) {
                String str = toFullBinaryString2(save[i]);
                ss.add(str.substring(32-save.length).replace('0','.').replace('1','Q'));
            }
            ans.add(ss);
            return;
        }
        int pos = limit&(~ (collimit | leftlimit | rightlimit) );
        int rightest;
        while (pos!=0){
            rightest = pos&(~pos+1);
            save[index] = rightest;
            pos -= rightest;
            process2(index+1,collimit|rightest
                    ,(leftlimit|rightest)<<1
                    ,(rightlimit|rightest)>>>1);
        }
    }

    public static void main(String[] args) {
        NQueensAllAnses nQueensAllAnses = new NQueensAllAnses();
        System.out.println(nQueensAllAnses.solveNQueens(4).toString());
    }
    public static String toFullBinaryString(int num){//将整数num转化为32位的二进制数
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char) (((num >> i) & 1) + '0');
        }
        return new String(chs);
    }
    public static String buffer = "00000000000000000000000000000000";
    public static String toFullBinaryString2(int num){//将整数num转化为32位的二进制数
        StringBuilder sb =new StringBuilder();
        sb.append(buffer).append(Integer.toBinaryString(num));
        return sb.substring(sb.length()-31);
    }


}
