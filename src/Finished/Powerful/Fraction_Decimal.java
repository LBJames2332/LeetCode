package Finished.Powerful;

import java.util.HashSet;
import java.util.Set;

public class Fraction_Decimal {
    class N{
        long val;
        N next;

        public N(long val) {
            this.val = val;
        }
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了61.96%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        Set<Long> set = new HashSet<>();
        //先算整数
        int N = numerator;
        int D = denominator;
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        StringBuilder stringBuilder = new StringBuilder();
        if ((N<0&&D>0)||(N>0&&D<0))stringBuilder.append("-");
        long left = num%den;
        stringBuilder.append((num/den));
        if (left==0) return stringBuilder.toString();
        stringBuilder.append(".");
        //肯定有余数
        set.add(left);
        N head = new N(left);
        N curr = head;
        while (left > 0){
            left = (left*10)%den;
            if (set.contains(left)){
                break;
            }
            else {
                if (left==0) break;
                set.add(left);
                curr.next = new N(left);
                curr = curr.next;
            }
        }

        if (left==0){

            while (head!=null){
                stringBuilder.append((10*head.val)/den);
                head = head.next;
            }
        }
        else {
            while (head.val!=left){
                stringBuilder.append((10*head.val)/den);
                head = head.next;
            }
            stringBuilder.append("(");
            while (head!=null){
                stringBuilder.append((10*head.val)/den);
                head = head.next;
            }
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Fraction_Decimal().fractionToDecimal(-1, -2147483648));
    }
}
