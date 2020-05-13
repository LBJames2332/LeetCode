package Finished;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LevelOrder {
    List<List<Integer>> Ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Ans;
        Queue<TreeNode>[] queue_List = new LinkedBlockingQueue[2];
        queue_List[0] = new LinkedBlockingQueue<>();
        queue_List[1] = new LinkedBlockingQueue<>();

        queue_List[0].add(root);
        int pos = 0;
        int cur_index = pos&1;
        int prev_index;
        while (queue_List[cur_index].size()>0){
            List<Integer> sub_l = new ArrayList<>();
            pos++;
            prev_index = cur_index;
            cur_index = pos&1;
            while (!queue_List[prev_index].isEmpty()){
                sub_l.add(queue_List[prev_index].peek().val);
                if (queue_List[prev_index].peek().left!=null) queue_List[cur_index].add(queue_List[prev_index].peek().left);
                if (queue_List[prev_index].peek().right!=null) queue_List[cur_index].add(queue_List[prev_index].peek().right);
                queue_List[prev_index].poll();

            }
            if (sub_l.size()>0) Ans.add(sub_l);
            else break;
        }
        return Ans;
    }
    static class TreeNode { int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(null));
    }
}
