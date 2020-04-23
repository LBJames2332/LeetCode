import java.util.*;

public class MostValidBrackets {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        HashSet<String> c = new HashSet<String>();
        c.iterator();
        for (String s : generateParenthesis(3)) System.out.println(s);
    }

    public static List<String> generateParenthesis(int n) {
        int count;
        boolean success;
        char[] c = new char[2 * n];

        List<String> l_s = new ArrayList<>();

        for (int i = (int) Math.pow(2, 2 * n); i < (int) Math.pow(2, 2 * n + 1); ++i) {

            System.out.println(n);
            String s = Integer.toBinaryString(i).substring(1);

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') c[j] = '(';
                else c[j] = ')';
            }

            for (int j = 0; j < c.length; j++) {
                System.out.println(c[j]);
            }
            count = 0;
            success = true;
            for (int j = 0; j < c.length; ++j) {
                System.out.println(count + " " + j);
                if (c[j] == '(') count++;
                else {
                    if (count == 0) {
                        success = false;
                        break;
                    } else count--;
                }
            }
            if (success && count == 0) {
                l_s.add(String.valueOf(c));
            }

        }
        return l_s;
    }
}