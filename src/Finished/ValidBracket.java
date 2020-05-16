package Finished;

import java.util.Stack;

public class ValidBracket {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.14%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.48%的用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] char_s = s.toCharArray();
        for (char c:char_s){
            switch (c){
                case ')':
                    if (stack.size()==0||stack.pop()!='(') return false;
                    break;

                case '}':
                    if (stack.size()==0||stack.pop()!='{') return false;
                    break;

                case ']':
                    if (stack.size()==0||stack.pop()!='[') return false;
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        return stack.size()==0?true:false;
    }
}
