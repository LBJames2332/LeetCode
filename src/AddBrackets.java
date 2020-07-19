public class AddBrackets {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        int count = 0;
        int ans = 0;
        for (char c:S.toCharArray()){
            if (c=='(') count++;
            else {
                if (count>0) count--;
                else ans++;
            }
        }
        return ans+count;
    }

    public static void main(String[] args) {
        System.out.println(new AddBrackets().minAddToMakeValid(")))((((("));
    }
}
