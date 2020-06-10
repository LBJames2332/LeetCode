public class IsPalindrome {
    /**
     * 执行用时 :9 ms, 在所有 Java 提交中击败了99.06%的用户
     * 内存消耗 :39.4 MB, 在所有 Java 提交中击败了5.14%的用户
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0||((x%10)==0&&x!=0)) return false;//末尾为0的情况（会导致后续反转位数缩减，产生问题，在这里提前解决）
        int second_half = 0;
        int left;
        while (x>second_half){//偶数位数的情况
            second_half *= 10;
            left = x % 10;
            second_half +=left;
            if (x<=second_half)break;//奇数位数的情况
            x /= 10;
        }
        return (x==second_half)?true:false;
    }
}
