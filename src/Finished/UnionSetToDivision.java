package Finished;

import java.util.*;

public class UnionSetToDivision {


    private Map<String,String> father = new HashMap();
    private Map<String,Double> val = new HashMap();//val存储的是每个string和祖先的倍数关系，在findfather的过程中更新完毕

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了69.74%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param equations
     * @param values
     */
    public UnionSetToDivision(List<List<String>> equations,double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            Union(equations.get(i).get(0),equations.get(i).get(1),values[i]);
        }
        for (Map.Entry<String,String>entry:father.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue()+"-"+val.get(entry.getKey()));
        }
    }
    private void Union(String s1,String s2,double beishu){
        //s1和s2是倍数倍，
        String f_1;
        String f_2;
        if (!father.containsKey(s1)){
            father.put(s1,s1);
            val.put(s1,1d);
            f_1 = s1;
        }
        else f_1 = findfather(s1);
        if (!father.containsKey(s2)){
            father.put(s2,s2);
            val.put(s2,1d);
            f_2 = s2;
        }
        else  f_2=findfather(s2);
        if (f_1!=f_2){
            //不相等，则将s1所在集合弄到s2所在集合中
            father.put(f_1,f_2);//后面的数字一般比较小，适合作为祖先
            val.put(f_1,val.getOrDefault(s2,1d)*beishu/val.getOrDefault(s1,1d));
        }
    }
    private String findfather(String s){//返回值是祖先
        String f = father.get(s);
        f = (f==s)?f:findfather(f);
        val.put(s,val.get(father.get(s))*val.get(s));
        father.put(s,f);
        return f;

    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionSetToDivision unionSetToDivision = new UnionSetToDivision(equations,values);
        double[] ans = new double[queries.size()];
        int index = 0;
        for (List<String> ls:queries) {

            ans[index++] = unionSetToDivision.cal(ls.get(0),ls.get(1));
        }
        return ans;
    }

    private double cal(String s, String s1) {
        if (!father.containsKey(s)||!father.containsKey(s1)) return -1;
        String farher1 = findfather(s);
        String farher2 = findfather(s1);
        if (!farher1.equals(farher2)) return -1;
        return val.get(s)/val.get(s1);

    }

    public static void main(String[] args) {
        List<List<String>> l_e = new ArrayList<>();
        List<String> ll = new ArrayList<>();
        ll.add("a");
        ll.add("b");
        l_e.add(ll);
        ll = new ArrayList<>();
        ll.add("b");
        ll.add("c");
        l_e.add(ll);

        List<List<String>> l_e2 = new ArrayList<>();
        List<String> ll2 = new ArrayList<>();
        ll2.add("a");
        ll2.add("c");
        l_e2.add(ll2);
        ll2 = new ArrayList<>();
        ll2.add("b");
        ll2.add("a");
        l_e2.add(ll2);
        ll2 = new ArrayList<>();
        ll2.add("a");
        ll2.add("e");
        l_e2.add(ll2);
        ll2 = new ArrayList<>();
        ll2.add("a");
        ll2.add("a");
        l_e2.add(ll2);
        ll2 = new ArrayList<>();
        ll2.add("x");
        ll2.add("x");
        l_e2.add(ll2);
        System.out.println(l_e2);
        System.out.println(Arrays.toString(calcEquation(l_e,new double[]{2.0,3.0},l_e2)));
        ;
    }



}
