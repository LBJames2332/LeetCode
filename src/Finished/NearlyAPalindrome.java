package Finished;

public class NearlyAPalindrome {
    /**
     * 执行用时 :8 ms, 在所有 Java 提交中击败了89.55%的用户
     * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了6.67%的用户
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (s.length()<3) return true;
        char[] char_S = s.toCharArray();

        int to = char_S.length>>1;
        int help = char_S.length - 1;
        boolean failed;
        for (int i = 0; i < to; i++) {
            if (char_S[i]!= char_S[help-i]){
                if (char_S[i]==char_S[help-i-1]){
                    help--;
                    failed = false;
                    for (int j = i+1; j < to; j++) {
                        if (char_S[j]!= char_S[help-j]) {
                            failed = true;
                            break;
                        }
                    }
                    if (!failed) return true;
                    help++;
                }

                if (char_S[i+1] == char_S[help - i]){
                    help++;
                    failed = false;
                    for (int j = i+1; j < to; j++) {
                        if (char_S[j]!= char_S[help-j]) {
                            failed = true;
                            break;
                        }
                    }
                    if (!failed) return true;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NearlyAPalindrome nearlyAPalindrome = new NearlyAPalindrome();
        System.out.println(nearlyAPalindrome.validPalindrome("abc"));
    }
}
