package Finished;

public class LongestSStrWith2nVowel {

    /**
     * 执行用时 :78 ms, 在所有 Java 提交中击败了30.49%的用户
     * 内存消耗 :44.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int length = s.length();
        byte[] b_s = s.getBytes();
        char cur;
        int max = 0;
        for (int i = 0; i < ((max>0)?length-max+1:length); i++) {
            cur = 0;
            for (int j = i; j < length; j++) {
                if (IsVowel(b_s[j])){
                    cur ^= b_s[j];

                }
                if (cur == 0) max = Math.max(max,j-i+1);
            }
        }
        System.out.println(max);
        return max;
    }

    private boolean IsVowel(byte b) {
        switch (b){
            case 105: return true;
            case 97: return true;
            case 101: return true;
            case 111: return true;
            case 117: return true;
            default: return false;
        }
    }

    public static void main(String[] args) {
        LongestSStrWith2nVowel longestSStrWith2nVowel = new LongestSStrWith2nVowel();
        System.out.println(0^'i');
        longestSStrWith2nVowel.findTheLongestSubstring("eleetminicoworoep");
    }
}
