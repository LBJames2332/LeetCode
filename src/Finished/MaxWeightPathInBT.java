package Finished;

import Tools.Classes.TreeNode;

public class MaxWeightPathInBT {
    int max;

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.57%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了7.69%的用户
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root==null) return 0;
        max = root.val;
        process(root);
        return max;
    }
    private int process(TreeNode node){
        //base
        if(node==null) return 0;
        int left = process(node.left);
        int right = process(node.right);
        max = Math.max(Math.max(Math.max(Math.max(max,left+node.val),right+node.val),left+right+node.val),node.val);
        //左边最大路径or右边最大路径（必小于等于max，所以不用考虑）
        //or左边到左节点的最大（left）+左节点的val
        //or右边到右节点的最大（right）+右节点的val
        //or左右跨过根节点

        return ((left>right)?left:right)+node.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(new MaxWeightPathInBT().maxPathSum(node1));
    }
}
