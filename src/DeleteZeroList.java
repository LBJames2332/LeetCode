import java.util.HashMap;
import java.util.Map;

public class DeleteZeroList {

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.37%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了12.50%的用户
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();

        ListNode prev_head = new ListNode(0);
        ListNode help = head;
        prev_head.next = head;
        map.put(0,prev_head);
        int sum = 0;
        while (help!=null){
            sum+=help.val;
            map.put(sum,help);
            help = help.next;
        }
        help = prev_head;
        sum = 0;
        while (help!=null){
            sum+=help.val;
            if (map.get(sum)!=help){
                help.next = map.get(sum).next;
            }

        }
        return prev_head.next;
    }
    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了30.61%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了12.50%的用户
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists2(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode marknode = new ListNode(0);
        marknode.next = head;
        map.put(0,marknode);
        ListNode return_node = head;
        int sum = 0;
        while (head!=null){
            sum += head.val;
            if (map.containsKey(sum)){
                ListNode help = map.get(sum);

//                System.out.println(sum);
                while (help.next!=head){
                    help = help.next;
                    sum+=help.val;
                    map.remove(sum);
                }
                help = help.next;
                sum+=help.val;
//                System.out.println(sum);
                if (map.get(sum) == marknode){
                    return_node = head.next;
                    marknode.next = return_node;
                }
                else map.get(sum).next = head.next;
            }
            else map.put(sum,head);
            head = head.next;
        }

        return return_node;
    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(-3);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(1);
//        node.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        node.next = node1;

        DeleteZeroList deleteZeroList = new DeleteZeroList();
        System.out.println(deleteZeroList.removeZeroSumSublists(node));
    }
}
