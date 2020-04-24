package NotFinished;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatchU {
    /**
     * 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议
     *
     * 1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
     * 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
     *
     * 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
     * ……
     * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！
     *
     * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
     * 注意：
     * 1. 两个特工不能埋伏在同一地点
     * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        List<Integer> l =  new ArrayList<>();
        for (int i = 0; i < N; i++) {
            l.add(sc.nextInt());
        }
        sc.close();
        int first;
        int pos_i;
        int[] ans = new int[3];
        for(int i = 0; i < l.size()-2;i++){
            //System.out.println(l.get(i));
            first = l.get(i);
            pos_i = i;
            for(int j = pos_i+1; j < l.size();j++){
                if(l.get(j)>=first+D){
                    //找到第一个不能接受的位置
                    if(j > pos_i+2){
                        //有的
                        //System.out.println("有的");
                        if (l.get(j) == first+D) OutPut(l,ans,pos_i,j,3);
                        else OutPut(l,ans,pos_i,j-1,3);
                    }
                    break;
                }
            }
        }
    }
    public static void OutPut(List<Integer> l,int[] a,int start,int end,int need){
        if (need==0) return;
        if(end+1 - start == need){
            for(int i = 3-need;i <3;i++){
                a[i] = l.get(start++);
            }
            System.out.println("?");
            printArray(a);
            return;
        }

        for(int i = start; i < end+1;i++){
            OutPut(l,a,i+1,end,need);
            a[3-need] = l.get(i);
            OutPut(l,a,i+1,end,need - 1);
        }
    }
    public static void printArray(int[] a){
        System.out.print("(");
        for(int i = 0; i < a.length-1;i++){
            System.out.print(a[i]+",");
        }
        System.out.print(a[a.length-1]+")");
    }
}
