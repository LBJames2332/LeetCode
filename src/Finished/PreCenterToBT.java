package Finished;

/**
 * 执行用时 :4 ms, 在所有 Java 提交中击败了63.79%的用户
 * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了73.33%的用户
 */
public class PreCenterToBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getRoot(0,preorder.length-1,0,preorder.length-1,preorder,inorder);
    }
    public TreeNode getRoot(int start_p,int end_p,int start_c,int end_c,int[] preorder, int[] inorder){
        if(start_p > end_p) return null;
        else {
            TreeNode root = new TreeNode(preorder[start_p]);
            for (int i = start_c; i <= end_c; i++) {
                if (inorder[i]==root.val){
                    root.left = getRoot(start_p+1,start_p+i-start_c,start_c,i-1,preorder,inorder);
                    root.right = getRoot(start_p+i-start_c+1,end_p,i+1,end_c,preorder,inorder);
                    break;
                }
            }
            return root;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
