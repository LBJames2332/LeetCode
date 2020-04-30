import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;

public class BSearchOrdedRotatedArray {
    private static boolean find = false;

    public static void main(String[] args) {

        Deque<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.offer(3);

        BSearchOrdedRotatedArray bSearchOrdedRotatedArray = new BSearchOrdedRotatedArray();
        System.out.println(bSearchOrdedRotatedArray.search(new int[]{1,3,5},5));
    }
    public int search(int[] nums, int target) {

        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,2);
        if(nums.length==0) return -1;
        return BinarySearch(nums,0,nums.length-1,target);
    }
    public int BinarySearch(int[]nums,int start,int end,int target){
        if (start>=end&&nums[start]!=target) return -1;//没找到
        int mid = (start+end)>>1;
        if (nums[mid]==target){
            return mid;
        }
        if (mid==start){
            //只需要找右边了
            return BinarySearch(nums,mid+1,end,target);
        }

        if (nums[mid-1]>nums[mid+1]){//在这里有转折了
            find=true;
            int return_value1 = -1;

            if (target >= nums[start]&&target <= nums[mid-1]){
                //左边要找
                return_value1 = BinarySearch(nums,start,mid-1,target);

            }
            if (return_value1!=-1) return return_value1;

            if (target >= nums[mid+1]&&target <= nums[end]){
                //右边要找
                return_value1 =  BinarySearch(nums,mid+1,end,target);
            }

            return return_value1;

        }
        else {
            if (find==false){
                //尚未有分支找到转折点
                //这种情况下两边都要搜索
                int a1 = BinarySearch(nums,start,mid-1,target);
                if (a1!=-1) return a1;
                a1 = BinarySearch(nums,mid+1,end,target);

                return a1;
            }
            else {
                //有地方找到分割点了，所以这里一定左右都递增
                int return_value1 = -1;
                if (target >= nums[start]&&target <= nums[mid-1]){
                    //左边要找
                    return_value1 =  BinarySearch(nums,start,mid-1,target);
                }
                if (return_value1!=-1) return return_value1;
                if (target >= nums[mid+1]&&target <= nums[end]){
                    //右边要找
                    return_value1 =  BinarySearch(nums,start,mid-1,target);
                }
                return return_value1;
            }
        }
    }
}
