package Finished;

public class IsValidBST {
    int prev = 0;
    boolean prev_Seted = false;
    boolean valid = true;

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39 MB, 在所有 Java 提交中击败了44.93%的用户
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode3 root) {

        CFS(root);

        return valid;
    }

    private void CFS(TreeNode3 root) {
        if (root==null) return;

        CFS(root.left);
        if (!valid) return;
        if (!prev_Seted){
            prev_Seted = true;
            prev = root.val;
        }
        else {
            if (root.val>prev) prev = root.val;
            else {
                valid = false;
                return;
            }
        }


        CFS(root.right);
        if (!valid) return;
    }
}

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3(int x) { val = x; }
}