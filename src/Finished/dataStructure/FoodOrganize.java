package Finished.dataStructure;

import java.util.*;

public class FoodOrganize {
    /**
     * 执行用时：50 ms, 在所有 Java 提交中击败了63.68%的用户
     * 内存消耗：47.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> food = new TreeSet<>();
        Map<Integer,Map<String,Integer>> map = new TreeMap<>();
        for (List<String> ll:orders){
            int t = Integer.parseInt(ll.get(1));
            String f = ll.get(2);
            if (!food.contains(f)) food.add(f);
            if (!map.containsKey(t)) map.put(t,new HashMap<>());
            Map<String, Integer> mm = map.get(t);
            mm.put(f,mm.getOrDefault(f,0)+1);
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> l_head = new ArrayList<>();
        l_head.add("Table");
        Iterator<String> it = food.iterator();
        while (it.hasNext()) {
            l_head.add(it.next());
        }
        ans.add(l_head);
        for (Map.Entry<Integer,Map<String,Integer>> entry:map.entrySet()){
            List<String> ls = new ArrayList<>();
            ls.add(entry.getKey()+"");
            Iterator<String> its = food.iterator();
            Map<String, Integer> value = entry.getValue();
            while (its.hasNext()) {
                String str = its.next();
                //ls.add((value.containsValue(str)?value.get(str):(1+"")+""));
                if (value.containsKey(str)){
                    ls.add(value.get(str)+"");
                }
                else ls.add(0+"");
            }
            ans.add(ls);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> ll = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add("David");
        ls.add("3");
        ls.add("Ceviche");
        List<String> ls1 = new ArrayList<>();
        ls1.add("Corina");
        ls1.add("10");
        ls1.add("Beef Burrito");
        List<String> ls2 = new ArrayList<>();
        ls2.add("David");
        ls2.add("3");
        ls2.add("Fried Chicken");
        List<String> ls3 = new ArrayList<>();
        ls3.add("Carla");
        ls3.add("5");
        ls3.add("Water");
        List<String> ls4 = new ArrayList<>();
        ls4.add("Carla");
        ls4.add("5");
        ls4.add("Ceviche");
        List<String> ls5 = new ArrayList<>();
        ls5.add("Rous");
        ls5.add("3");
        ls5.add("Ceviche");
        ll.add(ls);
        ll.add(ls1);
        ll.add(ls2);
        ll.add(ls3);
        ll.add(ls4);
        ll.add(ls5);
        System.out.println(new FoodOrganize().displayTable(ll));
    }
}
