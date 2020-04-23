package Finished;

public class LongestSubPalindrome {
    /**
     * 最长回文
     * 执行用时 :38 ms, 在所有 Java 提交中击败了66.01%的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了25.89%的用户
     */
    public static void main(String[] args) {
        String s = "bbaabbc";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int[] value = new int[s.length()];//计算以第i个位置上的点为中心点的首个点的最长回文长度
        value[0] = 1;
        value[s.length()-1] = 1;
        int count_1;
        int count_2;
        int off;
        int max_i=0;
        int type = 1;
        int type_loop;
        int max_length = 1;
        if (value.length>1){
            if (s.charAt(0)==s.charAt(1)) {
                value[0]=2;
                max_length = 2;
                type = 2;
            }
        }



        for (int i = 1; i < s.length()-1; i++) {
            off = 1;
            count_1 = 1;
            count_2 = 0;
            while (true){
                //奇数长度子串情况
                if (i<off||i+off>s.length()-1||s.charAt(i-off)!=s.charAt(i+off)) break;
                count_1+=2;
                off++;
            }

            if (s.charAt(i)==s.charAt(i+1)){
                //长度为偶数子串的情况
                off = 1;
                count_2 = 2;
                while (true){
                    if (i-off<0||i+2+off>s.length()||s.charAt(i-off)!=s.charAt(i+1+off))break;
                    count_2+=2;
                    off++;
                }
            }
            if (count_2>count_1){

                value[i] = count_2;
                type_loop = 2;
            }
            else {
                value[i] = count_1;
                type_loop = 1;
            }
            if (value[i] > max_length){
                max_i = i;
                max_length = value[i];
                type = type_loop;
            }
        }
        int off_set = max_length/2;
        if (type == 1){
            return s.substring(max_i-off_set,max_i+off_set+1);
        }
        else {
            return s.substring(max_i-off_set+1,max_i+off_set+1);
        }

    }
}
