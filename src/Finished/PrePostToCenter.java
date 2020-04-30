package Finished;

public class PrePostToCenter {
    public static void main(String[] args) {
        PrePostToCenter prePostToCenter = new PrePostToCenter();

        TreeNode root = prePostToCenter.constructFromPrePost(new int[]{2,1,3}, new int[]{3,1,2});
        prePostToCenter.Preorder(root);
    }
    public void Preorder(TreeNode root){
        if (root==null) return;
        System.out.println(root.val);
        if (root.left!=null) Preorder(root.left);
        if (root.right!=null) Preorder(root.right);
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length==0) return null;

        return nextNode(pre,0,pre.length-1,
                post,0,post.length-1);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param pre
     * @param s_pre :左子树的前序遍历的第一个元素所在位置
     * @param e_pre :在左子树中从s_pre往后找到before_value之前的元素为该左子树上的值
     * @param post
     * @param s_post :左子树的后序遍历的最后一个元素所在位置
     * @param e_post :在左子树中从e_post往前找到after_value之后的元素为该左子树上的值
     * @return
     */
    public TreeNode nextNode(int[]pre,int s_pre,int e_pre
                                ,int[]post,int s_post, int e_post){
        //找上一个根节点的左子树根节点(如果有必要)
        TreeNode root = new TreeNode(pre[s_pre]);
        if (s_pre==e_pre) return root;
        if (s_pre+1==e_pre){
            //仔细
            //子树只有一个顶点，则可以默认为左子树
            root.left = new TreeNode(pre[s_pre+1]);
            return root;
        }
        int search_NrootOfLTree = -1;
        for (int i = s_pre+2; i <= e_pre; i++) {
            if (pre[i] == post[e_post-1]){
                search_NrootOfLTree = i;
                break;
            }
        }
        if(search_NrootOfLTree==-1) {
            //左子树or只有右子树
            //完全可以当作只有左子树来写
            root.left = nextNode(pre,s_pre+1,e_pre,
                    post,s_post,e_post-1);
        }
        else {
            root.left = nextNode(pre,s_pre+1,search_NrootOfLTree-1,
                    post,s_post,search_NrootOfLTree-s_pre-2+s_post);

            root.right = nextNode(pre,search_NrootOfLTree,e_pre,
                    post,search_NrootOfLTree-s_pre+s_post-1,e_post-1);
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