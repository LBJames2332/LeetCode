package Finished;

public class SwapWithO0 {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {
        numbers[0]=numbers[0]^numbers[1];
        numbers[1]=numbers[0]^numbers[1];
        numbers[0]=numbers[0]^numbers[1];
        return numbers;
    }
}
