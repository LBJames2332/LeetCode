package Finished.ValidParentheses;

public class LongestValidParentheses {
    //想用前缀和来做

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了81.03%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了9.52%的用户
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
//        Map<Integer,Integer> map = new HashMap<>();//<sum,pos>
//        int sum = 0;
//        char[] char_s = s.toCharArray();
//        map.put(0,-1);
//        int ans = 0;
//        for (int i = 0; i < char_s.length; i++) {
//            if (char_s[i]=='('){
//                sum++;
//            }
//            else sum--;
//            if (map.containsKey(sum)){
//                ans = Math.max(ans,i-map.get(sum));
//            }
//            else {
//                map.put(sum,i);
//            }
//        }
//        return ans;
//        int sum = 0;
//        char[] char_s = s.toCharArray();
//        int ans = 0;
//        int index = 0;
//        while (index < char_s.length){
//            while (char_s[index]==')'){
//                index++;
//            }
//            int left = index;
//            while (index<char_s.length&&sum>=0){
//                if (char_s[index++]=='('){
//                    sum++;
//                }
//                else {
//                    sum--;
//                    if (sum==0) ans = Math.max(index - left,ans);
//                }
//                //index ++;
//
//            }
//            //if (ans == -1) ans = Math.max(index - left,ans);
//        }
//        return ans;
        int ans = 0;
        int left = 0;
        int right = 0;
        char[] char_S = s.toCharArray();
        for (int i = 0; i < char_S.length; i++) {
            if (char_S[i]=='(')left++;
            else right++;
            if (left==right) ans = Math.max(ans,left<<1);
            else if (left < right) left=right=0;
        }
        left = right = 0;
        for (int i = char_S.length-1; i > -1 ; i--) {
            if (char_S[i]=='(')left++;
            else right++;
            if (left==right) ans = Math.max(ans,left<<1);
            else if (left > right) left=right=0;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
    }
}
