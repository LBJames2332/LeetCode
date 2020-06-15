package Finished;

import Tools.Classes.TreeNode;

import java.util.*;

public class RepeatSubTree {
    List<TreeNode> ans = new ArrayList<>();
    Map<Integer,List<TreeNode>> map = new HashMap<>();//确保list里面存储的是不重复的子树根节点
    Set<TreeNode> ans_set = new HashSet<>();//标记是否已找到和该节点重复的子树
    Map<TreeNode,Integer> map_size = new HashMap<>();//标记是否已找到和该节点重复的子树

    /**
     * 执行用时 :64 ms, 在所有 Java 提交中击败了6.83%的用户
     * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        process(root);
        System.out.println(1132);
        return ans;
    }

    /**
     * 添加分支上的节点
     * 并返回顶点数
     * @param node
     * @return
     */
    private int process(TreeNode node) {
        if (node==null) return 0;
        int count = process(node.left);
        count += process(node.right);
        map_size.put(node,count);
        if (!map.containsKey(node.val)){
            List<TreeNode> ll = new ArrayList<>();
            ll.add(node);
            map.put(node.val,ll);
        }
        else {
            boolean finded = false;
            for (TreeNode root:map.get(node.val)){
                if (count==map_size.get(root)&&IsSame(root,node)) {
                    finded = true;
                    if (!ans_set.contains(root)){
                        ans.add(root);
                        ans_set.add(root);
                    }
                    break;
                }
            }
            if (!finded)  map.get(node.val).add(node);
        }
        return count+1;
    }

    private boolean IsSame(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null) return true;
        if (root1==null||root2==null) return false;
        if(root1.val!=root2.val) return false;
        return IsSame(root1.left,root2.left) && IsSame(root1.right,root2.right);

    }

    public static void main(String[] args) {
        System.out.println(1);
        RepeatSubTree repeatSubTree = new RepeatSubTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        repeatSubTree.findDuplicateSubtrees(node1);
    }
}
