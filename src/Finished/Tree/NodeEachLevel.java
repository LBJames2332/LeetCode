package Finished.Tree;

import Tools.Classes.ListNode;
import Tools.Classes.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NodeEachLevel {
    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了7.50%的用户
     * 内存消耗：38 MBS, 在所有 Java 提交中击败了100.00%的用户
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(tree);
        List<ListNode> listNodes = new ArrayList<>();
        TreeNode node;
        while (!queue.isEmpty()){
            int count = queue.size();
            node = queue.poll();
            ListNode firstnode = new ListNode(node.val);
            listNodes.add(firstnode);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
            for (int i = 1; i < count; i++) {
                node = queue.poll();
                firstnode.next = new ListNode(node.val);
                firstnode = firstnode.next;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);

            }
        }
        System.out.println(1);
        ListNode[] ans = new ListNode[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i++) {
            ans[i] = listNodes.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        NodeEachLevel nodeEachLevel = new NodeEachLevel();
        System.out.println(Arrays.toString(nodeEachLevel.listOfDepth(treeNode1)));
    }
}
