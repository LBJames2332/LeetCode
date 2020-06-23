package Finished;

import java.util.Stack;

public class BinaryStrAdd {
    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了55.55%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了7.69%的用户
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        Stack<Byte> stack = new Stack<>();
        char[] char_a = a.toCharArray();
        char[] char_b = b.toCharArray();
        int index_a = char_a.length-1;
        int index_b = char_b.length-1;
        byte jinwei = 0;
        byte left;
        byte sum;
        while (index_a>-1||index_b>-1){
            byte s_a = (byte) (index_a>-1?char_a[index_a]-'0':0);//拿到每个位置的值
            byte s_b = (byte) (index_b>-1?char_b[index_b]-'0':0);
            sum = (byte) (s_a+s_b+jinwei);
            left = (byte) (sum&1);
            jinwei = (byte) (((sum&2)==2)?1:0);
            stack.push(left);
            index_a--;
            index_b--;

        }
        if (jinwei==1)stack.push((byte) 1);
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BinaryStrAdd().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
