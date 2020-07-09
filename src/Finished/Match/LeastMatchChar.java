package Finished.Match;

import java.util.ArrayList;
import java.util.List;

public class LeastMatchChar {
    int[] dp;
    List<String>[] lists = new ArrayList[26];

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了89.85%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        if (sentence.length()==0) return 0;

        for (String s: dictionary){
            int index = s.charAt(0)-'a';
            if (lists[index]==null){
                lists[index] = new ArrayList<>();
            }
            lists[index].add(s);
        }
        dp = new int[sentence.length()+1];
        for (int i = 0; i < sentence.length(); i++) {
            dp[i] = -1;//-1表示没有计算过
        }
        return calculate(0,sentence);
    }

    private int calculate(int index,String sentence) {
        if (index>=dp.length) return dp.length;//不合法的输入直接给个最大返回
        if (dp[index]!=-1) return dp[index];
        if (lists[sentence.charAt(index)-'a']==null) {
            //从index开始匹配不上
            dp[index] = 1+ calculate(index+1,sentence);
            return dp[index];
        }
        int min = dp.length;

        for (String s:lists[sentence.charAt(index)-'a']) {
            int neednext = index+s.length();
            if ((neednext<=sentence.length())&&//长度不可以超过
                    (sentence.substring(index,neednext).equals(s))){//长度够且能匹配上
                min = Math.min(min,calculate(neednext,sentence));
            }
        }
        min = Math.min(min,1+ calculate(index+1,sentence));
        dp[index] = min;
        return min;
    }

    public static void main(String[] args) {
        //System.out.println("abc".substring(0,3));
        System.out.println(new LeastMatchChar().respace(new String[]{"looked","just","like","her","brother"},
                "jesslookedjustliketimherbrother"));
        }
}
