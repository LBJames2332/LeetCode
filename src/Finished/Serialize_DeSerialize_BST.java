package Finished;

public class Serialize_DeSerialize_BST {
    /**
     * 二叉树序列化反序列化
     * 执行用时 :13 ms, 在所有 Java 提交中击败了56.71%的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    String[] datas;
    int pos;
    StringBuilder stringBuilder;
    TreeNode CreateRoot(){
        if (pos > datas.length - 1) return null;
        if (datas[pos].equals(" ")) {
            pos++;
            return null;
        }
        TreeNode node = new TreeNode(FromStr(datas[pos++]));
        node.left = CreateRoot();
        node.right = CreateRoot();
        return node;

    }
    int FromStr(String str) {
        return Integer.valueOf(str).intValue();
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode deserialize(String data) {
        pos = 0;
        datas = data.split("/");
        return CreateRoot();
    }

    public String serialize(TreeNode root) {
        stringBuilder = new StringBuilder("");
        seralize_helper(root);
        return stringBuilder.toString();
    }
    void seralize_helper(TreeNode node){
        if (node==null) stringBuilder.append(" /");
        else {
            stringBuilder.append(node.val+"/");
            seralize_helper(node.left);
            seralize_helper(node.right);
        }
    }

    public static void main(String[] args) {
        Serialize_DeSerialize_BST serialize_deSerialize_bst = new Serialize_DeSerialize_BST();
        String data = "5/3/ / /7/6/ / /10/8/ / / ";
        TreeNode root = serialize_deSerialize_bst.deserialize(data);
        System.out.println(root.val);
        System.out.println(serialize_deSerialize_bst.serialize(root));
        TreeNode root2 = serialize_deSerialize_bst.deserialize(serialize_deSerialize_bst.serialize(root));
        System.out.println(root2.val);

    }
}
