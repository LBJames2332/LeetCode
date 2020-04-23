public class FindCenterNumber {
    /**
     * 找到两个有序数组（长度m,n）的中位数
     * 要求：log(m+n)
     */
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        int m = a.length;
        int n = b.length;
        //List<Integer> L_i = new ArrayList<>();
        ///Collections.sort(L_i);
//其实就是要找到第（m+n）/2大的数字
        while(true){
            /**
             * 第一次到这儿的时候说明：
             * a中有>=m/2个数大于b[n/2]
             * b中有>=n/2个数大于b[n/2]
             * 所以我们要找的数必然在b[n/2]右侧和a[m/2]中
             * 同理在
             * 否则
             * 在a[m/2右侧]和b中
             */

            if (a[m/2]>b[n/2]){

            }
            else if(a[m/2]<b[n/2]){

            }
            else return;
        }
    }
}
