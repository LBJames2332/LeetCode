import java.util.ArrayList;
import java.util.List;

public class delete {
    private  int a;
    public static void main(String[] args) {
        Integer a = 20;
        test(a);
        System.out.println(a);
        int[] a2 = new int[]{1,2};
        List<Integer> a3= new ArrayList<>();
        a3.add(1);
        a3.add(2);
        System.out.println(a3.toString());
    }
    public static void test(Integer a){
        a--;
    }
}
abstract class A{
    public A() {
    }
}