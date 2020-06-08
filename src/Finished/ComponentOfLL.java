package Finished;

import Tools.Classes.ListNode;

import java.util.HashMap;
import java.util.Map;

public class ComponentOfLL {
    /**
     * 执行用时 :8 ms, 在所有 Java 提交中击败了75.53%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了75.00%的用户
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i:G){
            map.put(i,true);
        }
        int length = 0;
        int count = 0;
        while (head!=null){
            if (map.containsKey(head.val)) {
                length++;
            }
            else {
                if (length>0) count++;
                length = 0;
            }
            head = head.next;
        }
        if (length>0) return count+1;
        return count;
    }

}
