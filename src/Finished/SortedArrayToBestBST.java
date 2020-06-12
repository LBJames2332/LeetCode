package Finished;

import Tools.Classes.TreeNode;

public class SortedArrayToBestBST {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(0,nums.length-1,nums);
    }

    private TreeNode process(int start, int end, int[] nums) {
        if (start>end) return null;
        //if (start==end) return new TreeNode(nums[start]);
        int mid = start+((end - start)>>1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(start,mid-1,nums);
        node.right = process(mid+1,end,nums);
        return node;
    }

    public static void main(String[] args) {
        new SortedArrayToBestBST().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

}
