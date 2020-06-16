package Finished;

import Tools.Classes.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SerializeBT {
    /**
     * 执行用时 :31 ms, 在所有 Java 提交中击败了35.44%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了21.43%的用户
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        TreeNode NNODE = new TreeNode(0);
        if (root==null) return "";//TODO check
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        Stack<TreeNode> stack = new Stack<>();
        if (root.right==null) stack.push(NNODE);
        else stack.push(root.right);
        if (root.left==null) stack.push(NNODE);
        else stack.push(root.left);
        //queue.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node==NNODE){
                stringBuilder.append(",null");
            }
            else {
                stringBuilder.append(","+node.val);
                if (node.right==null) stack.push(NNODE);
                else stack.push(node.right);
                if (node.left==null) stack.push(NNODE);
                else stack.push(node.left);

            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String[] nodes = data.split(",");
        List<String>ll = new LinkedList<>(Arrays.asList(nodes));
        TreeNode root = new TreeNode(Integer.parseInt(ll.remove(0)));
        putLeft(ll,root);
        putRight(ll,root);
        int a = 1+1;
        return root;
    }

    private void putRight(List<String> ll, TreeNode root) {
        String str = ll.remove(0);
        if (str.equals("null")){
            root.right = null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(str));
            root.right = node;
            putLeft(ll,node);
            putRight(ll,node);

        }
    }

    private void putLeft(List<String> ll, TreeNode root) {
        String str = ll.remove(0);
        if (str.equals("null")){
            root.left = null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(str));
            root.left = node;
            putLeft(ll,node);
            putRight(ll,node);
        }
    }

    public static void main(String[] args) {
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node1 = new TreeNode(1);
//        node3.left = node2;
//        node3.right = node4;
//        node2.left = node1;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        node1.left = node2;
        SerializeBT serializeBT = new SerializeBT();
        String serstr = serializeBT.serialize(node1);
        System.out.println(serstr);
        serializeBT.deserialize(serstr);
    }
}
