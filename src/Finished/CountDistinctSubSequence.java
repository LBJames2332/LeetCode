package Finished;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctSubSequence {
    long count;
    //    public int distinctSubseqII(String S) {
//        char [] char_S = S.toCharArray();
//        Set<Character> s = new HashSet<>();
//        count = 0;
//        for (int i = 0; i < S.length(); i++) {
//            if (!s.contains(char_S[i])){
//
//                s.add(char_S[i]);
//                SearchFrom(char_S,i+1);
//                count++;
//            }
//        }
//
//        return (int) (count%1_000_000_007);
//    }
//    public void SearchFrom(char[] cs,int start) {
//        Set<Character> s = new HashSet<>();
//        for (int i = start; i < cs.length; i++) {
//            if (!s.contains(cs[i])){
//                s.add(cs[i]);
//                SearchFrom(cs,i+1);
//                count++;
//            }
//        }
//    }

    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了11.49%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了50.00%的用户
     * @param S
     * @return
     */
    public int distinctSubseqII(String S) {
        if (S.length()==0) return 0;
        char [] char_S = S.toCharArray();
        int mod = 1_000_000_007;
        Map<Character,Integer> s = new HashMap<>();
        int []count = new int[char_S.length+1];

        count[0] = 1;
        for (int i = 0; i < S.length(); i++) {
            count[i+1] = count[i] * 2 % mod;

            if (s.containsKey(char_S[i])) {
                count[i+1] -= count[s.get(char_S[i])-1];
                count[i+1] %=mod;
            }
            s.put(char_S[i],i+1);
        }
        count[S.length()]--;
        if (count[S.length()] < 0) count[S.length()] += mod;
        System.out.println(count[S.length()]);
        return count[S.length()];
    }

    public static void main(String[] args) {
        CountDistinctSubSequence countDistinctSubSequence = new CountDistinctSubSequence();
        countDistinctSubSequence.distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn");
    }
}
