package Finished;

public class NumToStr {
    char[] char_s;
    int[] cont;//计算该以该位置为起点的情况个数
//    public int translateNum(int num) {
//        char_s = (""+num).toCharArray();
//        Calculate(0);
//        return 1;
//    }
//
//    private void Calculate(int index) {
//        if (char_s[index]=='0') return;
//        if (index==char_s.length){
//            count++;
//            return;
//        }
//        if (char_s[index]=='1'){
//            Calculate(index+1);
//            Calculate(index+2);
//            return;
//        }
//        if (char_s[index]=='2'){
//            Calculate(index++);
//            if (char_s[index]<'7') Calculate(index+1);
//        }
//        Calculate(index);
//    }

    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了13.29%的用户
     * 内存消耗 :36.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (cont.length==1) return 1;
        char_s = (""+num).toCharArray();
        cont = new int[char_s.length];
        cont[cont.length-1] = 1;
        int i = cont.length-2;
        switch (char_s[i]){
            case '1':
                cont[i] = 2;
                break;
            case 2:
                if (char_s[i+1]<'6') cont[i]=2;
                else cont[i] = 1;
                break;
            default:
                cont[i] = 1;
                break;
        }
        for (i = cont.length-3; i >=0 ; i--) {
            switch (char_s[i]){
                case '1':
                    cont[i] = cont[i+1]+cont[i+2];
                    break;
                case 2:
                    cont[i] = cont[i+1];
                    if (char_s[i+1]<'6') cont[i]+=cont[i+2];
                    break;
                default:
                    cont[i] = cont[i+1];
                    break;
            }
        }
        return cont[0];
    }
    public static void main(String[] args) {
        System.out.println(new NumToStr().translateNum(12138));
    }
}
