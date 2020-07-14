package Finished.Tree;

import Tools.Classes.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AddAlevelOfNodes {
    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了9.67%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了33.33%的用户
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if(d==1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (d > 2){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
            d--;
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode nodel = new TreeNode(v);
            TreeNode noder = new TreeNode(v);
            if (node.left!=null){
                nodel.left = node.left;
            }
            if (node.right!=null){
                noder.right = node.right;
            }
            node.left = nodel;
            node.right = noder;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        TreeNode node = new AddAlevelOfNodes().addOneRow(node1,5,4);
        System.out.println(1);
    }
}
