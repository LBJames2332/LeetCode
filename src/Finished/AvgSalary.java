package Finished;

public class AvgSalary {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = salary[0];
        for (int i = 1; i < salary.length; i++) {
            sum += salary[i];
            max = max>salary[i]?max:salary[i];
            min = min<salary[i]?min:salary[i];
        }
        return (double) (sum-max-min)/(salary.length-2);
    }

    public static void main(String[] args) {
        System.out.println(new AvgSalary().average(new int[]{1000,2000,1999,3000}));
    }
}
