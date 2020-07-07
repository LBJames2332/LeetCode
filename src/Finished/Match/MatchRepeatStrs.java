package Finished.Match;

public class MatchRepeatStrs {
    /**
     * 执行用时：346 ms, 在所有 Java 提交中击败了51.46%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了16.67%的用户
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length()<B.length()){
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;
        sb.append(A);
        return  sb.toString().contains(B)?(count+1):-1;
    }

    public static void main(String[] args) {
        System.out.println(new MatchRepeatStrs().repeatedStringMatch("abcd","cdabcdab"));
    }
}
