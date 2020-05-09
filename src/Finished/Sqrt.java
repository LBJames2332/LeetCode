package Finished;

public class Sqrt {
    public int mySqrt(int x) {
        int mid = x>>1;
        int start = 0;
        int end = x;
        while (mid!=start){
            if (mid*mid < x) start = mid;
            else if (mid*mid > x) end = mid;
            else return mid;
            mid  = (start+end)>>1;
        }
        if (end*end<=x) return end;
        return mid;
    }

    /**
     * NewTon
     */
    public int mySqrt2(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        for (int i = 0; i < 100; i++) {
            System.out.println(i+","+sqrt.mySqrt(i));
        }
    }
}
