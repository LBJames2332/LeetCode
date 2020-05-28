package Finished;

import java.util.Stack;

public class deCodeStr {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了38.53%的用户
     * 内存消耗 :38.4 MB, 在所有 Java 提交中击败了7.69%的用户
     * @param s
     * @return
     */
    public String decodeString(String s) {
        char[] char_s = s.toCharArray();
        StringBuilder help_sb = new StringBuilder();
        Stack<Integer> count = new Stack<>();
        Stack<Character> str = new Stack<>();
        int times;
        int i = 0;
        int begin;
        while (true){
            if (i==char_s.length) break;
            if ('0'<=char_s[i]&&char_s[i]<='9'){
                //从现在开始看看给的数字是多少
                begin = i++;
                while ('0'<=char_s[i]&&char_s[i]<='9') i++;
                times = Integer.valueOf(s.substring(begin,i)).intValue();
                count.push(times);
            }
            if (char_s[i]==']'){
                //该出栈了
                help_sb.delete( 0, help_sb.length());//从0开始，删这么长的内容
                while (str.peek()!='[') help_sb.insert(0,str.pop());
                str.pop();
                int c = count.pop();
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < help_sb.length(); k++) {
                        str.push(help_sb.charAt(k));
                    }
                }
                i++;

            }
            else str.push(char_s[i++]);

        }
        return toString(str);
    }

    public String toString(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) stringBuilder.insert(0,stack.pop());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        deCodeStr deCodeStr = new deCodeStr();
        System.out.println(deCodeStr.decodeString("2[abc]3[cd]ef"));
    }
}
