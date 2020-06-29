public class BucketSort {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了82.83%的用户
     * 内存消耗：37.5 MB, 在所有 Java 提交中击败了10.00%的用户
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int v:heights){
            bucket[v]++;
        }
        int index = 0;
        int ans=0;
        for (int i = 1; i < 101; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                if (heights[index++]!=i) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BucketSort().heightChecker(new int[]{5,1,2,3,4}));
    }

}
