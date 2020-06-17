public class TravelSchedule {
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了87.77%的用户
     * 内存消耗 :47.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int len = A.length;
        int[]positive = new int[len];
        int[]negative = new int[len];
        int[]biggestInRight = new int[len];


        for (int i = 0; i < len; i++) {
            positive[i] = A[i]+i;
            negative[i] = A[i]-i;
        }
        biggestInRight[len-2] = negative[len-1];
        for (int i = len - 3; i > -1 ; i--) {
            biggestInRight[i] = Math.max(negative[i+1],biggestInRight[i+1]);
        }
        int max = positive[0]+biggestInRight[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max,positive[i]+biggestInRight[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        new TravelSchedule().maxScoreSightseeingPair(new int[]{8,1,5,2,6});
    }
}
