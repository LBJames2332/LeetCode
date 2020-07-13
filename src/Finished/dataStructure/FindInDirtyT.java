package Finished.dataStructure;

import Tools.Classes.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindInDirtyT {
    Set<Integer> set = new HashSet<>();

    /**
     * 执行用时：30 ms, 在所有 Java 提交中击败了70.33%的用户
     * 内存消耗：44.9 MB, 在所有 Java 提交中击败了85.71%的用户
     * @param root
     */
    public FindInDirtyT(TreeNode root) {
        preOrder(root,0);
    }

    private void preOrder(TreeNode root,int val) {
        if (root==null) return;
        set.add(val);
        preOrder(root.left,(val<<1)+1);
        preOrder(root.right,(val<<1)+2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
