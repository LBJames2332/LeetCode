package Finished;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int x) { val = x; }
    }

    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了70.05%的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了39.71%的用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        DivideMerge(lists,0,lists.length-1);
        return lists[0];
    }
    public ListNode mergeKListsHeap(ListNode[] lists) {
        ListNode head = new ListNode(1);
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node:lists) {
            if (node!=null) nodes.add(node);
        }
        ListNode current;
        current = nodes.poll();
        head.next = current;
        if (current.next!=null) nodes.add(current.next);
        while (nodes.size()>0){
            current.next = nodes.poll();
            current = current.next;
            if (current.next!=null) nodes.add(current.next);
        }
        return head.next;
    }
    public void DivideMerge(ListNode[] lists,int start,int end) {
        if (start==end) return;
        int mid = (end+start)>>1;
        DivideMerge(lists,start,mid);
        DivideMerge(lists,mid+1,end);
        lists[start] = merge2Lists(lists[start],lists[mid]);
        lists[mid+1] = merge2Lists(lists[mid+1],lists[end]);
        lists[start] = merge2Lists(lists[start],lists[mid+1]);
    }
    public ListNode merge2Lists(ListNode root1,ListNode root2) {


        if (root1==root2) return root1;
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        ListNode curr;
        if (root1.val < root2.val){
            curr = root1;
            curr.next = merge2Lists(root1.next,root2);
        }
        else{
            curr = root2;
            curr.next = merge2Lists(root1,root2.next);
        }
        return curr;
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode root11  = new ListNode(1);
//        ListNode root12 = new ListNode(4);
//        ListNode root13 = new ListNode(5);
//        root11.next = root12;
//        root12.next = root13;
//        ListNode root21  = new ListNode(1);
//        ListNode root22 = new ListNode(3);
//        ListNode root23 = new ListNode(4);
//        root21.next = root22;
//        root22.next = root23;
//        ListNode root31  = new ListNode(2);
//        ListNode root32 = new ListNode(6);
//        root31.next = root32;
//        ListNode[] listNodes1 = new ListNode[3];
//        listNodes1[0] = root11;
//        listNodes1[1] = root21;
//        listNodes1[2] = root31;
        ListNode root1 = new ListNode(-10
                ,new ListNode(-6
                ,new ListNode(-4
                ,new ListNode(-4
                ,new ListNode(0
                ,new ListNode(2
                ,new ListNode(2
                ,new ListNode(2
                ,new ListNode(2)))))))));
        ListNode root2 = new ListNode(-5
                ,new ListNode(1
                ,new ListNode(3
                ,new ListNode(4
                ,new ListNode(4
                ,new ListNode(4))))));
        ListNode root3 = new ListNode(-9);
        ListNode root4 = new ListNode(-9);
        ListNode root5 = new ListNode(-10
                ,new ListNode(-8
                ,new ListNode(-5
                ,new ListNode(-4
                ,new ListNode(-3
                ,new ListNode(-3
                ,new ListNode(-2
                ,new ListNode(4))))))));
        ListNode root6 = new ListNode(-10
                ,new ListNode(-8
                ,new ListNode(-7
                ,new ListNode(-4
                ,new ListNode(-4
                ,new ListNode(0
                ,new ListNode(1
                ,new ListNode(2))))))));
        ListNode root7 = new ListNode(-8
                ,new ListNode(-1
                ,new ListNode(4)));
        ListNode root8 = new ListNode(-6
                ,new ListNode(-5
                ,new ListNode(-2
                ,new ListNode(-2
                ,new ListNode(-1
                ,new ListNode(1
                ,new ListNode(3
                ,new ListNode(4))))))));
        System.out.println("rootvalue");
        while (root8!=null){
            System.out.print(root8.val+" ");
            root8 = root8.next;
        }
        ListNode[] listNodes1 = new ListNode[8];

        listNodes1[0] = root1;
        listNodes1[1] = root2;
        listNodes1[2] = root3;
        listNodes1[3] = root4;
        listNodes1[4] = root5;
        listNodes1[5] = root6;
        listNodes1[6] = root7;
        listNodes1[7] = root8;
        System.out.println(listNodes1.length);
        ListNode root = mergeKLists.mergeKListsHeap(listNodes1);
        while (root!=null){
            System.out.print(root.val+" ");
            root = root.next;
        }
    }
}
