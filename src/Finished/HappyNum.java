package Finished;

public class HappyNum {
    public static void main(String[] args) {
        HappyNum happyNum = new HappyNum();
        System.out.println(happyNum.isHappy(4));
    }
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 执行用时 :2 ms, 在所有 Java 提交中击败了51.98%的用户
     * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了8.33%的用户
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果 可以变为  1，那么这个数就是快乐数。如果 n 是快乐数就返回 True ；不是，则返回 False
     * 链接：https://leetcode-cn.com/problems/happy-number
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Node root = new Node(n);
        Node root_fast = root;
        Node root_slow = root;
        int help_int;
        while (root_fast.val!=1){
            help_int = calculate(root_fast.val);
            if (help_int==1) return true;
            root_fast.next = new Node(help_int);
            root_fast = root_fast.next;
            help_int = calculate(root_fast.val);
            if (help_int==1) return true;
            root_fast.next = new Node(help_int);
            root_fast = root_fast.next;
            root_slow = root_slow.next;
            if (root_fast.val == root_slow.val) return false;

        }
        return false;
    }
    public int calculate(int n){
        int return_value = 0;
        int top;
        int end;
        while (n!=0){

            end = n%10;
            return_value+=end*end;
            n/=10;
        }
        return return_value;
    }
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
