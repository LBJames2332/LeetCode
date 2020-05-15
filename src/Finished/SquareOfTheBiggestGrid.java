package Finished;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SquareOfTheBiggestGrid {
    //    public int maxAreaOfIsland(int[][] grid) {
//        Node[][] parent = new Node[grid.length][];
//        Set<Node> headSet = new HashSet<>();
//        for (int i = 0; i < parent.length; i++) {
//            parent[i] = new Node[grid[i].length];
//        }
//        int first_Line = -1;
//        for (int i = 0; i < grid.length; i++) {
//            if (grid[i].length>0){
//                first_Line = i;
//                break;
//            }
//        }
//        if (first_Line== - 1) return 0;
//        if (grid[first_Line][0]==1){
//            Node node = new Node(first_Line,0);
//            node.square = 1;
//            headSet.add(node);
//            parent[first_Line][0] = node;
//        }
//        //搞定第一排
//
//        for (int i = 1; i < grid[first_Line].length; i++) {
//            if (grid[first_Line][i]==1){
//                Node node = new Node(first_Line,i);
//                if (parent[first_Line][i-1]!=null){
//                    parent[first_Line][i] = parent[first_Line][i - 1];
//                    parent[first_Line][i].square++;
//                    addAAfterB(node, parent[first_Line][i]);
//
//                }
//                else {
//
//                    node.square = 1;
//                    headSet.add(node);
//                    parent[first_Line][i] = node;
//                }
//            }
//        }
//        //搞定第一列
//        for (int i = first_Line+1; i < grid.length; i++) {
//            if (grid[i]!=null){
//                if (grid[i][0]==1){
//                    Node node = new Node(i,0);
//                    if (parent[i -1][0]!=null){
//                        parent[i][0] = parent[i-1][0];
//                        parent[i][0].square++;
//                        addAAfterB(node, parent[i][0]);
//
//                    }
//                    else {
//
//                        node.square = 1;
//                        headSet.add(node);
//                        parent[i][0] = node;
//                    }
//                }
//            }
//
//        }
//        for (int i = first_Line+1; i < grid.length; i++) {
//            for (int j = 1; j < grid[i].length; j++) {
//                if (grid[i][j]==1){
//                    Node node = new Node(i,j);
//                    if (parent[i][j-1]!=null&&parent[i-1][j]!=null){
//                        if (parent[i][j -1]!=parent[i -1][j]){
//                            //麻烦的地方
//                            //左边的挪到上边
//                            Node head = parent[i][j -1];
//                            headSet.remove(head);
//                            parent[i-1][j].square +=(1+head.square);
//                            //Node nodeleft = new Node(i - 1,j);
//                            //nodeleft.next = root.next;
//                            //addAAfterB(nodeleft,parent[i-1][j]);
//                            Node tail = head;
//                            while (tail!=null){
//                                parent[tail.x][tail.y] = parent[i-1][j];
//                                tail = tail.next;
//                            }
//                            tail.next = parent[i-1][j].next;
//                            parent[i -1][j].next = head;
//                        }
//                        else {
//                            parent[i][j-1].square++;
//                            addAAfterB(node, parent[i][j-1]);
//                        }
//                    }
//                    else {
//                        if (parent[i][j - 1]==null){
//                            if (parent[i -1][j]!=null){
//                                parent[i-1][j].square++;
//                                addAAfterB(node, parent[i-1][j]);
//                            }
//                            else {
//                                node.square = 1;
//                                headSet.add(node);
//                                parent[i][0] = node;
//                            }
//                        }
//                        else {
//                            parent[i][j - 1].square++;
//                            addAAfterB(node, parent[i][j - 1]);
//                        }
//                    }
//
//                }
//            }
//        }
//        int max = 0;
//        Iterator<Node> iter = headSet.iterator();
//        while (iter.hasNext()){
//            max = Math.max(max,iter.next().square);
//        }
////        for (int i = 0; i < grid.length; i++) {
////            for (int j = 0; j < grid[i].length; j++) {
////                if (grid[i][j]==1){
////                    System.out.println(parent[i][j].square+" ");
////                }
////                else System.out.println("0 ");
////            }
////            System.out.println();
////        }
//        return max;
//    }
    public int maxAreaOfIsland(int[][] grid) {
        Node[][] parent = new Node[grid.length][grid[0].length];
        Set<Node> headSet = new HashSet<>();



        if (grid[0][0]==1){
            Node node = new Node(0,0);
            node.square = 1;
            headSet.add(node);
            parent[0][0] = node;
        }
        //搞定第一排

        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i]==1){
                Node node = new Node(0,i);
                if (parent[0][i-1]!=null){
                    parent[0][i] = parent[0][i - 1];
                    parent[0][i].square++;
                    addAAfterB(node, parent[0][i]);

                }
                else {

                    node.square = 1;
                    headSet.add(node);
                    parent[0][i] = node;
                }
            }
        }
        //搞定第一列
        for (int i = 1; i < grid.length; i++) {

            if (grid[i][0]==1){
                Node node = new Node(i,0);
                if (parent[i -1][0]!=null){
                    parent[i][0] = parent[i-1][0];
                    parent[i][0].square++;
                    addAAfterB(node, parent[i][0]);

                }
                else {

                    node.square = 1;
                    headSet.add(node);
                    parent[i][0] = node;
                }
            }


        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j]==1){
                    Node node = new Node(i,j);
                    if ((parent[i][j-1]!=null)&&(parent[i-1][j]!=null)){
                        if (parent[i][j -1]!=parent[i -1][j]){
                            //麻烦的地方
                            //左边的挪到上边
                            Node head = parent[i][j -1];
                            headSet.remove(head);
                            parent[i-1][j].square +=(1+head.square);
                            Node tail = new Node(0,0);
                            tail = head;
                            while (tail.next!=null){
                                parent[tail.x][tail.y] = parent[i-1][j];
                                tail = tail.next;
                            }
                            parent[tail.x][tail.y] = parent[i-1][j];
                            tail.next = parent[i-1][j].next;
                            parent[i -1][j].next = head;
                            parent[i][j] = parent[i-1][j];
                        }
                        else {
                            parent[i][j-1].square++;
                            parent[i][j] = parent[i][j-1];
                            addAAfterB(node, parent[i][j-1]);
                        }
                    }
                    else {
                        if (parent[i][j - 1]==null){
                            if (parent[i -1][j]!=null){
                                parent[i][j] = parent[i-1][j];
                                parent[i-1][j].square++;
                                addAAfterB(node, parent[i-1][j]);
                            }
                            else {
                                node.square = 1;
                                headSet.add(node);
                                parent[i][j] = node;
                            }
                        }
                        else {
                            parent[i][j] = parent[i][j-1];
                            parent[i][j - 1].square++;
                            addAAfterB(node, parent[i][j - 1]);
                        }
                    }

                }
            }
        }
        int max = 0;
        Iterator<Node> iter = headSet.iterator();
        while (iter.hasNext()){
            max = Math.max(max,iter.next().square);
        }
        return max;
    }
    public  void  addAAfterB(Node A,Node B){
        A.next = B.next;
        B.next = A;
    }
    static class Node{
        int x;
        int y;
        int square;
        Node next;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int l_square = 0;
    boolean[][] marked;

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了70.51%的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了91.67%的用户
     * @param grid
     * @return
     */
    public int maxAreaOfIsland_BFS(int[][] grid) {
        marked = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1&&marked[i][j]==false){
                    l_square = 0;
                    Test(grid,i,j);
                    max = Math.max(max,l_square);
                }
            }
        }
        return max;
    }

    private void Test(int[][] grid, int i, int j) {
        if (i < 0||i >= grid.length||j<0||j >= grid[0].length||grid[i][j]==0||marked[i][j]==true) return;
        l_square++;
        marked[i][j] = true;
        Test(grid,i-1,j);
        Test(grid,i+1,j);
        Test(grid,i,j-1);
        Test(grid,i,j+1);

    }

    public static void main(String[] args) {
        SquareOfTheBiggestGrid squareOfTheBiggestGrid = new SquareOfTheBiggestGrid();
        System.out.println(squareOfTheBiggestGrid.maxAreaOfIsland(new int[][]
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
    /**
     * {{0,0,1,0,0,0,0,1,0,0,0,0,0},
     *                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
     *                         {0,1,1,0,1,0,0,0,0,0,0,0,0},
     *                         {0,1,0,0,1,1,0,0,1,0,1,0,0},
     *                         {0,1,0,0,1,1,0,0,1,1,1,0,0},
     *                         {0,0,0,0,0,0,0,0,0,0,1,0,0},
     *                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
     *                         {0,0,0,0,0,0,0,1,1,0,0,0,0}}
     */
}
