package Finished;

public class GrowFlower {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了8.33%的用户
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int prev_flower = -2;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0){
                if (i>prev_flower+1&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
                    count++;
                    prev_flower = i;
                }
            }
            else {
                prev_flower = i;
            }
        }
        return count>=n;
    }

    public static void main(String[] args) {
        System.out.println(new GrowFlower().canPlaceFlowers(new int[]{1,0,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,0},6));
    }
}
