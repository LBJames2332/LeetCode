package Finished;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindEnd {
    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了23.72%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        Map<String,Integer> ans = new HashMap<>();
        for (List<String> ll:paths){
            ans.put(ll.get(0),ans.getOrDefault(ll.get(0),0)+2);
            ans.put(ll.get(1),ans.getOrDefault(ll.get(1),0)+1);
        }
        for (Map.Entry<String,Integer>entry:ans.entrySet()){
            if (entry.getValue()==1)return entry.getKey();
        }
        return null;
    }
}
