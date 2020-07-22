package Finished.Powerful;

public class MinimumInSA {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了43.33%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int s = 0;
        int e = numbers.length - 1;
        while (s < e){
            int mid = s + ((e - s)>>>1);
            if (numbers[mid] < numbers[e]){
                //此时mid在[target,e]上,所以右边界变为mid
                e = mid;
            }
            else if (numbers[mid] > numbers[e]){
                //此时很明显在[mid,e]上
                s = mid + 1;
            }
            else e--;
        }
        return numbers[s];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumInSA().minArray(new int[]{2,2,2,0,1}));
    }
}
