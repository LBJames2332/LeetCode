package Finished;

import Tools.Classes.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PreOrder2BT {
    /**
     * 执行用时 :21 ms, 在所有 Java 提交中击败了17.29%的用户
     * 内存消耗 :40.8 MB, 在所有 Java 提交中击败了25.00%的用户
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
//        System.out.println(Arrays.toString(S.split("-")));
        List<Node> ll = new LinkedList<>();
        int count=0;
        for (String s:S.split("-")){
            if (!s.equals("")){
                ll.add(new Node(Integer.parseInt(s),count));
                count = 1;
            }
            else count++;
        }
        for (Node node:ll){
            System.out.println(node.val+"  "+node.level);
        }
        Node n = ll.remove(0);
        TreeNode root = new TreeNode(n.val);
        process(root,n,ll);

        Node reInfo;
        if ((reInfo=process(root,n,ll))!=null){//由这个左孩子继续看后面的
            //if (n.level==reInfo.level - 1){
                Node n2 = reInfo;
                TreeNode root2 = new TreeNode(n2.val);
                root.right = root2;
            //}
            //System.out.println("不可能");
            process(root2,reInfo,ll);
        }
        return root;

    }

    private Node process(TreeNode root, Node n, List<Node> ll) {
        if (ll.isEmpty()) return null;
        if (ll.get(0).level==n.level+1){
            //如果是父节点的level+1，则必是父节点的左孩子
            Node n1 = ll.remove(0);
            TreeNode root1 = new TreeNode(n1.val);
            root.left = root1;
            Node reInfo;
            if ((reInfo=process(root1,n1,ll))!=null){//由这个左孩子继续看后面的
                if (n.level==reInfo.level-1){
                    TreeNode root2 = new TreeNode(reInfo.val);
                    root.right = root2;
                    return process(root2,reInfo,ll);
                }
                return reInfo;

            }
            return null;
        }
        else {
            return ll.remove(0);
        }
    }

    public static void main(String[] args) {
        new PreOrder2BT().recoverFromPreorder("1-2--3---4-5--6---7");
    }
    class Node{
        int val;
        int level;

        public Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }
    class Info{
        Node node;
        int f_level;//其父的level

        public Info(Node node, int f_level) {
            this.node = node;
            this.f_level = f_level;
        }
    }
}
