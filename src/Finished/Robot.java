package Finished;

public class Robot {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了48.15%的用户
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] count = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==0) {
            count[0][0] = 1;
            int index = 1;
            while (index<obstacleGrid.length&&obstacleGrid[index][0]==0){
                count[index++][0] = 1;
            }
            index = 1;

            while (index<obstacleGrid[0].length && obstacleGrid[0][index]==0){
                count[0][index++] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j]==0){
                    count[i][j]=count[i-1][j]+count[i][j-1];
                }
            }
        }
        return count[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(new Robot().uniquePathsWithObstacles(new int[][]{
                {0}
        }));
    }
}
