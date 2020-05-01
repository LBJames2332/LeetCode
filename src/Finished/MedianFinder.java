package Finished;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianFinder {

    /** initialize your data structure here. */
    /**
     * Your Finished.MedianFinder object will be instantiated and called as such:
     * Finished.MedianFinder obj = new Finished.MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    List<Integer> BigHeap = new ArrayList<>();
    List<Integer> SmallHeap = new ArrayList<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (BigHeap.size()==0) BigHeap.add(num);
        else {
            if (num>BigHeap.get(0)){
                addIntoSmall(num);
                Modify();
            }
            else {
                addIntoBig(num);
                Modify();
            }
        }
    }

    private void Modify() {
        if (BigHeap.size()>SmallHeap.size()){
            if (BigHeap.size()-SmallHeap.size() == 2){
                addIntoSmall(BigHeap.get(0));
                BigHeap.set(0,BigHeap.get(BigHeap.size()-1));
                BigHeap.remove(BigHeap.size()-1);
                int index = 0;
                int leftSon = 1;
                int rightSon = 2;
                if (leftSon > BigHeap.size()-1) {
                    leftSon = index;
                    rightSon = index;
                }
                else if (leftSon == BigHeap.size() - 1) rightSon = leftSon;
                int Maxindex;
                while (BigHeap.get(index)<BigHeap.get(leftSon)||
                        BigHeap.get(index)<BigHeap.get(rightSon)){

                    Maxindex = BigHeap.get(leftSon)>BigHeap.get(rightSon)?leftSon:rightSon;
                    swap(BigHeap,index,Maxindex);
                    index = Maxindex;
                    leftSon = index<<1+1;
                    rightSon = leftSon+1;
                    if (leftSon > BigHeap.size()-1) break;
                    if (leftSon == BigHeap.size() - 1) rightSon = leftSon;
                }
            }
        }
        else if (BigHeap.size()<SmallHeap.size()){
            if (SmallHeap.size()-BigHeap.size() == 2){
                addIntoBig(SmallHeap.get(0));
                SmallHeap.set(0,SmallHeap.get(SmallHeap.size()-1));
                SmallHeap.remove(SmallHeap.size()-1);
                int index = 0;
                int leftSon = 1;
                int rightSon = 2;
                if (leftSon >SmallHeap.size()-1) {
                    leftSon = index;
                    rightSon = index;
                }
                else if (leftSon == SmallHeap.size() - 1) rightSon = leftSon;
                int Minindex;
                while (SmallHeap.get(index)>SmallHeap.get(leftSon)||
                        SmallHeap.get(index)>SmallHeap.get(rightSon)){

                    Minindex = SmallHeap.get(leftSon)<SmallHeap.get(rightSon)?leftSon:rightSon;
                    swap(SmallHeap,index,Minindex);
                    index = Minindex;
                    leftSon = index<<1+1;
                    rightSon = leftSon+1;
                    if (leftSon >SmallHeap.size()-1) break;
                    if (leftSon == SmallHeap.size() - 1) rightSon = leftSon;
                }
            }
        }
    }

    private void addIntoSmall(int val) {
        SmallHeap.add(val);
        int index = SmallHeap.size()-1;
        int father = (index-1)/2;
        while (SmallHeap.get(index) < SmallHeap.get(father)){
            swap(SmallHeap,father,index);
            index = father;
            father = (father-1)/2;
        }
    }

    private void addIntoBig(int val) {
        BigHeap.add(val);
        int index = BigHeap.size()-1;
        int father = (index-1)/2;
        while (BigHeap.get(index) > BigHeap.get(father)){
            swap(BigHeap,father,index);
            index = father;
            father = (father-1)/2;
        }

    }

    public void swap(List<Integer> nums,int p1,int p2){
        int temp = nums.get(p1);
        nums.set(p1,nums.get(p2));
        nums.set(p2,temp);
    }
    public double findMedian() {
        if (BigHeap.size()>SmallHeap.size()) return BigHeap.get(0);
        if (BigHeap.size()<SmallHeap.size()) return SmallHeap.get(0);
        else {
            return (BigHeap.get(0)+SmallHeap.get(0))/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        medianFinder.addNum(3);
//        medianFinder.addNum(5);
        Scanner sc = new Scanner(System.in);
        int num;
        while (true){
            num = sc.nextInt();
            medianFinder.addNum(num);
            System.out.println(medianFinder.findMedian());
        }
    }
}