package Finished;

import java.util.ArrayList;

public class RomanNumber {
    static ArrayList<RomanNum> arr = new ArrayList<>(13);
    static {
        arr.add(new RomanNum(1000,"M"));
        arr.add(new RomanNum(900,"CM"));
        arr.add(new RomanNum(500,"D"));
        arr.add(new RomanNum(400,"CD"));
        arr.add(new RomanNum(100,"C"));
        arr.add(new RomanNum(90,"XC"));
        arr.add(new RomanNum(50,"L"));
        arr.add(new RomanNum(40,"XL"));
        arr.add(new RomanNum(10,"X"));
        arr.add(new RomanNum(9,"IX"));
        arr.add(new RomanNum(5,"V"));
        arr.add(new RomanNum(4,"IV"));
        arr.add(new RomanNum(1,"I"));
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了86.29%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了7.41%的用户
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int curr_index = 0;
        while (num!=0){
            while (arr.get(curr_index).val>num){
                curr_index++;
            }
            int count = num/arr.get(curr_index).val;
            num = num%arr.get(curr_index).val;
            for (int i = 0; i < count; i++) {
                sb.append(arr.get(curr_index).roman_val);
            }
            curr_index++;
        }
        return sb.toString();
    }
    static class RomanNum {
        int val;
        String roman_val;

        public RomanNum(int val, String roman_val) {
            this.val = val;
            this.roman_val = roman_val;
        }

        @Override
        public String toString() {
            return "RomanNum{" +
                    "val=" + val +
                    ", roman_val='" + roman_val + '\'' +
                    '}'+"\n";
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanNumber().intToRoman(2444));

    }
}
