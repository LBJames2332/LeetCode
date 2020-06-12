package Finished;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class IntToString {
    /**
     * 执行用时 :9 ms, 在所有 Java 提交中击败了30.82%的用户
     * 内存消耗 :38.9 MB, 在所有 Java 提交中击败了5.41%的用户
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String[] strs = new String[2];
        strs[0] = "1";
        strs[1]="";
        int pos = 0;
        for (int i = 1; i < n; i++) {
            char[] char_from = strs[pos].toCharArray();
            char[] char_to = strs[pos^1].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < char_from.length; j++) {
                char now = char_from[j];
                int count = 1;
                j++;
                for (;j<char_from.length;j++){
                    if (char_from[j]==now){
                        count++;
                    }
                    else {
                        break;
                    }
                }
                sb.append(""+count).append(now);
                j--;//TODO check
            }
            strs[pos^1] = sb.toString();
            pos ^= 1;
        }
        return strs[pos];

    }

    /**
     * 栈
     * @param n
     * @return
     */
    public String countAndSay_2(int n) {
        Queue<Character>[] queues = new Queue[2];
        queues[0] = new LinkedBlockingQueue<>();
        queues[1] = new LinkedBlockingQueue<>();
        queues[0].add('1');
        int pos = 0;
        for (int i = 1; i < n; i++) {
            while (!queues[pos].isEmpty()){
                char now = queues[pos].poll();
                int count = 1;
                while ((!queues[pos].isEmpty())&&queues[pos].peek()==now){
                    count++;
                    queues[pos].poll();
                }

                queues[pos^1].add((char) (count+'0'));
                queues[pos^1].add(now);

            }
            pos ^= 1;
        }
        StringBuilder sb = new StringBuilder();
        while (!queues[pos].isEmpty()){
            sb.append(queues[pos].poll());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        new IntToString().countAndSay_2(6);
    }
}
