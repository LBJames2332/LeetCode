package Finished;

public class StringMulti {
    /**给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * https://leetcode-cn.com/problems/multiply-strings/
     * 执行用时 :12 ms, 在所有 Java 提交中击败了42.21%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了7.41%的用户
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {

        int subAns;
        if (num1.length()==0||num2.length()==0) return null;
        if (num1.equals("0")||num2.equals("0")) return "0";
        char[] num = new char[num1.length()+num2.length()];

        int help;
        int add;
        int pos;
        for (int i = 0; i < num.length; i++) {
            num[i] = '0';
        }
        for (int i = num1.length()-1; i >= 0 ; i--) {
            for (int j = num2.length()-1; j >= 0 ; j--) {
                subAns = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                pos = num.length+j-num2.length()+i-(num1.length()-1);
                add = (num[pos]-'0')+(subAns%10);
                num[pos] = (char) (add%10+'0');
                num[pos-1] += subAns/10+add/10;
            }
        }
        return new String(num).replaceAll("^(0+)", "");
    }

    public static void main(String[] args) {
        System.out.println(multiply("0","0"));
    }
}
