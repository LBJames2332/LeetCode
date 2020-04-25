package Finished;

import java.util.*;

/**
 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
 */
public class MostValidBrackets {
    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap<>();
//        HashSet<String> c = new HashSet<String>();
//        c.iterator();
        for (String s : generateParenthesis(3)) System.out.println(s);
    }
    /*public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        HashSet<String> c = new HashSet<String>();
        c.iterator();
        for (String s : generateParenthesis(3)) System.out.println(s);
    }

    public static List<String> generateParenthesis(int n) {
        int count;
        boolean success;
        char[] c = new char[2 * n];

        List<String> l_s = new ArrayList<>();

        for (int i = (int) Math.pow(2, 2 * n); i < (int) Math.pow(2, 2 * n + 1); ++i) {

            System.out.println(n);
            String s = Integer.toBinaryString(i).substring(1);

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') c[j] = '(';
                else c[j] = ')';
            }

            for (int j = 0; j < c.length; j++) {
                System.out.println(c[j]);
            }
            count = 0;
            success = true;
            for (int j = 0; j < c.length; ++j) {
                System.out.println(count + " " + j);
                if (c[j] == '(') count++;
                else {
                    if (count == 0) {
                        success = false;
                        break;
                    } else count--;
                }
            }
            if (success && count == 0) {
                l_s.add(String.valueOf(c));
            }

        }
        return l_s;
    }*/
    static int[] record = new int[2];
    static Stack<Character> stack = new Stack<>();
    static StringBuffer str_buffer = new StringBuffer();
    static List<String> ANS = new ArrayList<>();

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了54.00%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了5.26%的用户
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {

        record[0] = n-1;
        record[1] = n;

        stack.add('(');


        str_buffer.append('(');
        loop();
        return ANS;
    }

    public static void loop(){
        if (record[0]>0){
            //还有‘（’，并想加入‘（’
            stack.add('(');
            str_buffer.append('(');
            record[0]--;
            loop();
            stack.pop();
            str_buffer.delete(str_buffer.length()-1,str_buffer.length());
            record[0]++;
        }
        if (record[0]==0){//没有‘（’了
            if (record[1]==stack.size()){
                //刚好也没有‘）’了
                //加入结果
                for (int i = 0; i < record[1]; i++) {
                    str_buffer.append(')');
                }
                String s = new String(str_buffer);
                ANS.add(s);
                str_buffer.delete(str_buffer.length()-record[1],str_buffer.length());
            }
            return;
        }
        if (record[1]>0){
            //还有‘）’剩下，接下来想要加‘）’
            if (stack.size()>0) {
                stack.pop();
                str_buffer.append(')');
                record[1]--;
                loop();
                stack.add('(');
                str_buffer.delete(str_buffer.length()-1,str_buffer.length());
                record[1]++;

            }
            else return;//但是没前面没有能匹配的‘（’，则不行
        }
        if (record[1]==0){
            //没有‘）’了
            if (stack.size()==0){
                //‘（’也恰好全部匹配上了
                //加入结果
                //‘）’全加进去了，而且‘（’全抵消了，此时是一个合法的括号
                String s = new String(str_buffer);
                ANS.add(s);
            }
            return;
        }
    }

}