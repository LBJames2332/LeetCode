package Finished;

public class CopyLinkedListWithRandomPointer {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了68.18%的用户
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node help = head;
        while (help!=null){
            Node node = new Node(help.val);
            node.next = help.next;
            help.next = node;
            help = node.next;
        }
        help = head;
        Node ans = head.next;
        Node prev;
        while (help!=null){
            prev = help;
            help = help.next;
            if (prev.random!=null) help.random = prev.random.next;
            help = help.next;
        }
        prev = head;

        while (prev!=null){
            help = prev.next;
            if (help!=null){
                prev.next = help.next;
                prev = help;
            }
            else break;

        }
        return ans;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyLinkedListWithRandomPointer copyLinkedListWithRandomPointer = new CopyLinkedListWithRandomPointer();
        copyLinkedListWithRandomPointer.copyRandomList(node1);
    }
    static class Node{
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
        }
    }
}
