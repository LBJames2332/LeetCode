package Finished;

import java.util.LinkedList;
import java.util.List;

public class LettersFromPhoneNumber {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了5.17%的用户
     */
    List<String> ans = new LinkedList<>();
    static char[][] buffer = new char[10][];
    static {
        buffer[2] = new char[3];
        buffer[3] = new char[3];
        buffer[4] = new char[3];
        buffer[5] = new char[3];
        buffer[6] = new char[3];
        buffer[7] = new char[4];
        buffer[8] = new char[3];
        buffer[9] = new char[4];
        char first = 'a';
        for (byte i = 2; i < 10; i++) {
            for (byte j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = (char) first++;
            }
        }
    }
    char[] char_S;
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)return ans;
        char_S  = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        process(sb,0);
        return ans;
    }

    private void process(StringBuilder sb, int i) {
        if (i==char_S.length) {
            ans.add(sb.toString());
            return;
        }
        for (byte j = 0; j < buffer[char_S[i]-'0'].length; j++) {
            sb.append(buffer[char_S[i]-'0'][j]);
            process(sb,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LettersFromPhoneNumber().letterCombinations("23224"));
    }
}
