package Finished;

public class TimeToZero {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了29.74%的用户
     * 内存消耗 :36.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param num
     * @return
     */
    public int numberOfSteps (int num) {
        if (num==0) return 0;
        else return 1+((num&1)==1?numberOfSteps(num-1):numberOfSteps(num>>1));
    }

    public static void main(String[] args) {
        TimeToZero timeToZero = new TimeToZero();
        System.out.println(timeToZero.numberOfSteps(14));
    }
}
