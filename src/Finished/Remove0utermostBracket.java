package Finished;

public class Remove0utermostBracket {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.96%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了7.69%的用户
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder(S.length());
        char[] char_s = S.toCharArray();
        for (int i = 1; i < char_s.length; i++) {
            if (char_s[i]=='(') {
                sb.append('(');
                count ++;
            }
            else {
                if (count==0) i++;
                else {
                    sb.append(')');
                    count --;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Remove0utermostBracket().removeOuterParentheses("(()())(())(()(()))"));
    }
}
