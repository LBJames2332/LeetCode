package Finished;

public class MountainArray {
    /**
     *
     * 返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
     * 如果不存在这样的下标 index，就请返回 -1。
     * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 对 Finished.MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param target
     * @param mountainArr
     * @return
     */

    public int findInMountainArray(int target, MountainArray2 mountainArr) {
        //二分法
        int top = findInTop(mountainArr);
        System.out.println(top);
        if (target > mountainArr.get(top)) return -1;
        int ans = -1;
        if (target >= mountainArr.get(0))  ans = BinarySearchMountainLeft(target,mountainArr,0,top-1);
        if (ans !=-1) return ans;
        else return BinarySearchMountainRight(target,mountainArr,top+1,mountainArr.length()-1);
    }
    public int findInTop(MountainArray2 mountainArr) {
        //二分法
        //先找到顶点
        int low = 0;
        int high = mountainArr.length()-1;
        int mid;
        int v_mid;
        int v_right;
        int v_left;
        while (low < high){
            mid = (low+high)>>1;
            if (mid==low)  {
                v_right = mountainArr.get(mid+1);
                v_mid = mountainArr.get(mid);
                return (v_right>v_mid)?(mid+1):mid;
            }

            //if (mid==high) return mid;
            v_left = mountainArr.get(mid-1);
            v_right = mountainArr.get(mid+1);
            v_mid = mountainArr.get(mid);
            if (v_mid>v_left &&v_mid>v_right)return mid;
            if (v_left > v_mid){//可优化
                //在右边
                high = mid-1;
            }
            else {//可优化
                //在左边
                low = mid+1;
            }
        }
        return low;
    }
    public int BinarySearchMountainLeft(int target,MountainArray2 mountainArray,int start,int end){
        //左边是递增的情况
        if (end<start) return -1;
        if (end==start){
            if (mountainArray.get(start)==target) return start;
            else return -1;
        }
        int mid = (start+end)>>1;
        int value = mountainArray.get(mid);
        if (value==target) return mid;
        if (value>target) return BinarySearchMountainLeft(target,mountainArray,start,mid-1);
        else return BinarySearchMountainLeft(target,mountainArray,mid+1,end);
    }
    public int BinarySearchMountainRight(int target,MountainArray2 mountainArray,int start,int end){
        //右边边是递减的情况
        if (end<start) return -1;
        if (end==start){
            if (mountainArray.get(start)==target) return start;
            else return -1;
        }
        int mid = (start+end)>>1;
        int value = mountainArray.get(mid);
        if (value==target) return mid;
        if (value>target) return BinarySearchMountainRight(target,mountainArray,mid+1,end);
        else return BinarySearchMountainRight(target,mountainArray,start,mid-1);
    }
    public static void main(String[] args) {
        MArray arr = new MArray(new int[]{1,2,3,5,3});
        MountainArray main = new MountainArray();
        System.out.println(main.findInMountainArray(0,arr));
    }
}
interface MountainArray2 {
    int get(int index);

    int length();
}
class MArray implements MountainArray2{
    private int[] arr;
    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }

    public MArray(int[] arr) {
        this.arr = arr;
    }
}