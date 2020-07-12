package Finished.Tree;

import Tools.Classes.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfSonTree {
    Map<Integer,Integer> map = new HashMap<>();

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了51.21%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null) return new int[0];
        int sum = SumOf(root);
        int max = map.get(sum);
        int count = 0;
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            int c = entry.getValue();//要出现次数最多的
            if (c>max){
                max = c;
                count = 1;
            }
            else if (c==max) count++;
        }
        int[] ans = new int[count];
        count = 0;
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            if (entry.getValue() == max) ans[count++] = entry.getKey();
        }
        return ans;

    }

    private int SumOf(TreeNode node) {
        if (node==null) return 0;
        int sum_l = SumOf(node.left);
        int sum_r = SumOf(node.right);
        int sum = sum_l+sum_r+node.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-5);
        node1.left = node2;
        node1.right = node3;
        System.out.println(Arrays.toString(new SumOfSonTree().findFrequentTreeSum(node1)));
    }
}
