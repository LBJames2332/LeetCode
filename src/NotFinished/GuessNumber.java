package NotFinished;

public class GuessNumber {

    public static void main(String[] args) {
        System.out.println(getAnswer(5));
    }
    public static int getAnswer(int n) {
        // 横坐标代表范围的起始值， 纵坐标代表范围的最大值
        int[][] mem = new int[n+1][n+1];
        int temp;
        for (int gap = 1;gap < n;gap++){
            //gap表示（i,j）范围间隔的个数如1——5，gap为4
            for (int j = 1; j < n-gap+1; j++) {
                //j是起点
                //（j,j+gap）的范围内的最优决策的最差结果
                //求mem[j][j+gap]
                temp = Integer.MAX_VALUE;
                for (int k = j+1; k <= j+gap; k++) {
                    //k是终点
                    temp = min(temp,k + max(mem[j][k-1],mem[j+1][j+gap]));
                }
                mem[j][j+gap] = temp;
                System.out.println(j+" "+(j+gap)+" "+temp);
            }
        }
        return mem[1][n];
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static int min(int a,int b){
        return a>b?b:a;
    }
}
