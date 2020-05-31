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

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了91.80%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {

        ListNode help = head;
        ListNode return_prev = new ListNode(0);
        return_prev.next = head;
        ListNode help_prev = return_prev;
        while (help!=null&&help.next!=null){
            if (help.next.val!=help_prev.next.val){
                help = help.next;
                help_prev = help_prev.next;
            }
            else {
                while (help.next!=null&&help.next.val==help_prev.next.val){

                    help = help.next;
                }
                help_prev.next  = help.next;
                help = help.next;
            }
        }
        return return_prev.next;
    }
}
