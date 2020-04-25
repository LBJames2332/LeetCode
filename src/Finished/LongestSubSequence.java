package Finished;

public class LongestSubSequence {
    //经典问题最长子序列
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence_better("bsbininm","jmjkbkjkv"));
    }

    /**
     * DP 菜鸡版
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        System.out.println("break");
        int[][] record = new int[text1.length()+1][text2.length()+1];
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int start = 0;
        int minlength = (text1.length()<text2.length())
                ?text1.length():text2.length();
        for (int i = start; i < record.length; i++) {
            record[i][0] = 0;
        }
        for (int i = start; i < record[0].length; i++) {
            record[0][i] = 0;
        }

        while (start< minlength){
            start++;
            System.out.println(start);
            for (int i = start; i < record.length; i++) {
                if (c1[i-1]==c2[start-1]) record[i][start] = 1+record[i-1][start-1];
                else {
                    record[i][start] = (record[i][start-1]>record[i-1][start])
                            ?record[i][start-1]:record[i-1][start];
                }
                System.out.println(i+" "+start+" "+record[i][start]);
            }
            for (int i = start; i < record[0].length; i++) {
                if (c1[start-1]==c2[i-1]) record[start][i] = 1+record[start-1][i-1];
                else {
                    record[start][i] = ((record[start][i-1]>record[start-1][i])
                            ?record[start][i-1]:record[start-1][i]);
                }
                System.out.println(start+" "+i+" "+record[start][i]);
            }
        }
        return record[record.length-1][record[0].length-1];

    }

    /**
     * DP进阶版
     * 执行用时 :8 ms, 在所有 Java 提交中击败了93.22%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了8.33%的用户
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence_better(String text1, String text2) {
        int top;
        int left_top = 0;
        int[] left = new int[text1.length()];
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int nextleft_top;
        for (int i = 0; i < text2.length(); i++) {
            //开始一列的求解
            top = 0;
            left_top = 0;
            for (int j = 0; j < text1.length(); j++) {
                //一列一列的求
                nextleft_top = left[j];
                if (c1[j]==c2[i]) left[j] = 1+left_top;
                else left[j] = ((left[j]>top)?left[j]:top);
                top = left[j];
                left_top = nextleft_top;
            }
        }
        return left[left.length-1];

    }
}
