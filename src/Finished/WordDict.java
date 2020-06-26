package Finished;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class WordDict {
    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了67.91%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了8.00%的用户
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] char_s = s.toCharArray();
        boolean[] mark = new boolean[s.length()];
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(-1);
        boolean marked;
        while (!queue.isEmpty()){
            int index = queue.poll();
            System.out.println(index);
            //从每个位置尝试每个字典中的字符串
            for (String ss:wordDict){
                int range = index + ss.length();
                if (range < s.length()){//若超长度，则必然不可行
                    if (!mark[range]){//若已有标记，则该长度必可行，不必再探究这个的可能性
                        marked = false;
                        for (int i = 0; i < ss.length(); i++) {
                            if (char_s[index+1+i]!=ss.charAt(i)){
                                marked = true;
                                break;
                            }
                        }
                        if (!marked) {
                            mark[index + ss.length()] = true;
                            queue.add(index+ss.length());
                        }
                    }
                }

            }
        }
        return mark[mark.length-1];
    }

    //    private boolean getDP(int index,List<String> wordDict) {
//        if (dp[index]) return true;
//        for (String s:wordDict){
//            if (getDP(index - s.length(),wordDict)&&)
//        }
//        return getDP(index - )
//    }
    public static void main(String[] args) {
        List<String> ll = new ArrayList<>();
        ll.add("leet");
        ll.add("code");
        System.out.println(new WordDict().wordBreak("leetcode", ll));
    }
}
