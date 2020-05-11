package Valuable_for_Practise;

import java.util.*;

public class SealDown {

    Stack<Integer> ans = new Stack<>();
    char[] char_s;
    char[] char_t;
    List<Integer> remark = new ArrayList<>();
    boolean[] mark;

    /**
     * 印章问题
     * 执行用时 :7 ms, 在所有 Java 提交中击败了83.33%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param stamp
     * @param target
     * @return
     */
    public int[] movesToStamp(String stamp, String target) {
        char_s = stamp.toCharArray();
        char_t = target.toCharArray();
        boolean exist = true;
        mark  = new boolean[char_t.length];
        if (char_s[0]!=char_t[0]||char_s[char_s.length - 1]!=char_t[char_t.length - 1]) return new int[0];
        for (int i = 0; i <= char_t.length-char_s.length; i++) {
            if (char_t[i] == char_s[0]){
                exist = true;
                for (int j = 1; j < char_s.length; j++) {
                    if (char_t[i + j]!=char_s[j]){
                        exist = false;
                        break;
                    }
                }
                if (exist){
                   //有那样的情况
                    for (int j = 0; j < char_s.length; j++) mark[i+j]= true;
                    ans.add(i);
                    if (remark.size()>0&&i == remark.get(remark.size() - 1)+1){
                        remark.set(remark.size() - 1,i+char_s.length-1);
                    }
                    else {
                        remark.add(i);
                        remark.add(i+char_s.length-1);
                    }
                    i += char_s.length-1;
                }

            }
        }

        if (remark.size()>0){
            int pos;
            int prev_tail;
            int v1;
            int v2;
            int help;
            int next_head;
            boolean modify = true;
            while (modify){
                pos = 0;
                prev_tail = -1;
                v1 = remark.get(pos++);
                v2 = remark.get(pos++);
                modify = false;
                while (true){
                    help = MarkLeft(v1 - 1);
                    if (help!=v1) {
                        modify = true;
                        if (help <= prev_tail + 1){
                            //可以接起来
                            if (prev_tail == -1){
                                remark.set(pos - 2,help);
                            }
                            else {
                                remark.remove(pos-3);
                                remark.remove(pos-3);
                                v2 = remark.get(pos - 3);
                                pos -= 2;
                            }
                        }
                        else remark.set(pos - 2,help);
                    }

                    //if (v2 == char_t.length-1) break;
                    next_head = remark.size()>(pos++)?remark.get(pos - 1):char_t.length;
                    help = MarkRight(v2+1);
                    if (help!=v2) {
                        modify = true;
                        if (help >= next_head - 1){
                            //可以接起来
                            if (next_head == char_t.length) remark.set((pos--) - 2,help);
                            else{
                                remark.remove(pos-2);
                                remark.remove(pos-2);
                                pos -= 1;
                            }
                        }
                        else remark.set((pos--) - 2,help);
                    }

                    else pos--;



                    //if (modify) pos-=2;
                    if (remark.size() > pos){
                        prev_tail = remark.get(pos - 1);
                        v1 = remark.size()>pos?remark.get(pos++):char_t.length;
                        v2 = remark.get(pos++);
                    }
                    else break;
                }
            }
        }
        if (remark.size()==2&&remark.get(0)==0&&remark.get(1)==char_t.length - 1){
            int pos = 0;
            int[] A_ans = new int[ans.size()];
            while (!ans.empty()){
                A_ans[pos++] = ans.pop();
            }
            return A_ans;//
        }
        return new int[0];//若是能完成戳印，一定有一块连续的和stamp相同的部分最后按下印记。得找到这样的，并围绕它展开
    }

    private int MarkLeft(int end) {
        if (end < 0) return end+1;
        boolean exist;
        int limit = Math.max(end - char_s.length+1,0);
        for (int i = end; i >= limit ; i--) {
            if (char_t[i] == char_s[0]||mark[i] == true){
                exist = true;
                for (int j = i+1; j <= end; j++) {
                    if (char_t[j] != char_s[j - i]){
                        if (mark[j]==false){
                            exist = false;
                        }
                    }
                }
                if (exist){
                    for (int j = i; j <= end; j++) mark[j] = true;
                    ans.add(i);
                    return i;
                }
            }
        }
        return end+1;
    }

    private int MarkRight(int start) {
        if (start==char_t.length) return start - 1;
        boolean exist;
        int limit = Math.min(start+char_s.length - 1,char_t.length - 1);
        for (int i = start; i <= limit; i++) {
            if (char_t[i] == char_s[char_s.length - 1]||mark[i]==true){
                exist = true;
                int pos = char_s.length - 2;
                for (int j = i - 1; j >= start; j--) {
                    if (char_t[j] != char_s[pos--]){
                        if (mark[j]==false){
                            exist = false;
                        }
                    }
                }
                if (exist){
                    for (int j = i; j >= start; j--) mark[j] = true;
                    ans.add(i-char_s.length+1);
                    return i;
                }
            }
        }
        return start - 1;
    }
    public static void main(String[] args) {
        SealDown sealDown = new SealDown();
        System.out.println(Arrays.toString(sealDown.movesToStamp("zbs","zbzbsbszbssbzbszbsss")));
    }
}