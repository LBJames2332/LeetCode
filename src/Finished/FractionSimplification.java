package Finished;

import java.util.Arrays;

public class FractionSimplification {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param cont
     * @return
     */
    public int[] fraction(int[] cont) {
        int pos = cont.length - 1;
        int mother = 1;
        int son = cont[pos--];
        int help;
        while (pos >=0){
            System.out.println(mother+" "+son);
            help = son;
            son = mother;
            mother = help;
            son = cont[pos--]*mother+son;

        }
        return new int[]{son,mother};

    }

    public static void main(String[] args) {
        FractionSimplification fractionSimplification = new FractionSimplification();
        System.out.println(Arrays.toString(fractionSimplification.fraction(new int[]{0,0,3})));
    }
}
