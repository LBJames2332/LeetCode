import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class DelRepeatedNodesInList {
    /**
     * 执行用时 :11 ms, 在所有 Java 提交中击败了5.71%的用户
     * 内存消耗 :38.9 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        Queue<ListNode> queue = new LinkedBlockingQueue<>();
        Map<Integer,Integer> map = new HashMap<>();
        ListNode help = head;
        while (help!=null){
            map.put(help.val,map.getOrDefault(help.val,0)+1);
            queue.add(help);
            help = help.next;
        }
        ListNode prev_head = new ListNode(1);
        ListNode mark = prev_head;
        while (!queue.isEmpty()){
            if (map.get(queue.peek().val)==1){
                prev_head.next = queue.poll();
                prev_head = prev_head.next;
            }
            else {
                queue.poll();
                prev_head.next = null;
            }
        }
        return mark.next;
    }
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
