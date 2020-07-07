package Finished.Match;

import java.util.Arrays;

public class IDMatch {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了25.00%的用户
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int min = 0;
        int max = S.length();
        int[] ans = new int[S.length()+1];
        int index_ans = 0;
        int index_s = 0;
        char[] char_s = S.toCharArray();
        while (index_s < char_s.length){
            //计算连续相同的个数
            int count = 1;
            while (index_s < (char_s.length-1)&&char_s[index_s+1] == char_s[index_s]){
                index_s++;
                count++;
            }
            if (char_s[index_s]=='I'){
                for (int i = 0; i <count ; i++) {
                    ans[index_ans++] = min + i;
                }
                min += count;
            }else {
                for (int i = 0; i < count ; i++) {
                    ans[index_ans++] = max - i;
                }
                max -= count;
            }
            index_s++;
        }
        ans[index_ans] = min+((max-min)>>1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IDMatch().diStringMatch("IDID")));
    }
}
