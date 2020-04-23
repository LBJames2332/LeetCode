package Finished;

public class PalindromeLink {
    /**回文链表
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.82%的用户
     * 内存消耗 :42.4 MB, 在所有 Java 提交中击败了10.81%的用户
     */
    PalindromeLink next;
    int value;

    public PalindromeLink() {
        this.next = null;
        this.value = 0;
    }

    public PalindromeLink(PalindromeLink next, int value) {
        this.next = next;
        this.value = value;
    }

    public static PalindromeLink inverseLink(PalindromeLink head){
        PalindromeLink prev = null;
        PalindromeLink curr = head;
        while (curr!=null){
            PalindromeLink nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;

        }
        return prev;
    }
    public static void printLink(PalindromeLink head){
        PalindromeLink node = head;
        while (node!=null){
            System.out.println(node.value);
            node = node.next;

        }
    }
    public static boolean isPalindrome(PalindromeLink head) {
        int length=0;
        PalindromeLink centernode = head;
        while (centernode!=null){
            length++;
            centernode = centernode.next;
        }
        int center;
        if((length&1)==1){
            center = (length>>1)+1;
        }
        else {
            center = length>>1;
        }
        System.out.println(center);
        length = 0;
        centernode = head;
        while ((length++)<center){
            centernode = centernode.next;
        }
        centernode = inverseLink(centernode);
        System.out.println(centernode.value);
        System.out.println(head.value);
        while (centernode!=null){
            if (head.value!=centernode.value) return false;
            head = head.next;
            centernode = centernode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLink head = new PalindromeLink
                (new PalindromeLink
                        (new PalindromeLink
                                (new PalindromeLink
                                        (new PalindromeLink
                                                (null,1),3),3),2),1);
    }
}
