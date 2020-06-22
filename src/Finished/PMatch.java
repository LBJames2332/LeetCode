package Finished;

public class PMatch {
    char[] char_p;
    char[] char_v;

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了51.40%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        if (pattern.length()==0) return value.length()==0;
        boolean geta = false;
        boolean getb = false;
        char_p = pattern.toCharArray();
        char_v = value.toCharArray();
        int posa = pattern.length();
        int posb = pattern.length();
        int counta = 0;
        int countb = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (char_p[i]=='a'){
                if (!geta) {
                    posa = i;
                    geta = true;
                }
                counta++;
            }
            else {
                if (!getb) {
                    posb = i;
                    getb = true;
                }
                countb++;
            }
        }
        if((!geta)||(!getb)) {
            if (!geta){
                if (value.length()%countb>0) return false;
                return check("",value.substring(0,value.length()/countb));
            }
            else {
                if (value.length()%counta>0) return false;
                return check(value.substring(0,value.length()/counta),"");
            }
        }

        int len1;
        int len2;
        String pa;
        String pb;
        if (posa<posb){
            for (len1 = 0; len1 <= value.length()/counta; len1++) {
                if ((value.length()-len1*counta)%countb>0)continue;
                else {
                    len2 = (value.length()-len1*counta)/countb;
                    //System.out.println(len1+"  "+len2);
                    pa = value.substring(0,len1);
                    pb = value.substring(posb*len1,posb*len1+len2);
                    //System.out.println(pa+" "+pb);
                    if(check(pa,pb)) return true;

                }
            }
        }
        else {
            for (len2 = 0; len2 <= value.length()/countb; len2++) {
                if ((value.length()-len2*countb)%counta > 0) continue;
                else {
                    len1 = (value.length()-len2*countb)/counta;
                    //System.out.println(len1+"  "+len2);
                    pb = value.substring(0,len2);
                    pa = value.substring(posa*len2,posa*len2+len1);
                    //System.out.println(pa+" "+pb);
                    if (check(pa,pb)) return true;

                }
            }
        }
        return false;
    }

    private boolean check(String pa, String pb) {
        if(pa.equals(pb))return false;
        int indexv = 0;
        for (char c:char_p){
            if (c=='a'){
                for (int i = 0; i < pa.length(); i++) {
                    if (char_v[indexv++]!=pa.charAt(i)) return false;
                }
            }
            else {
                for (int i = 0; i < pb.length(); i++) {
                    if (char_v[indexv++]!=pb.charAt(i)) return false;
                }
            }
        }
        return true;
    }
    private boolean check1(String pa, String pb) {
        int indexv = 0;
        for (char c:char_p){
            if (c=='a'){
                for (int i = 0; i < pa.length(); i++) {
                    if (char_v[indexv++]!=pa.charAt(i)) return false;
                }
            }
            else {
                for (int i = 0; i < pb.length(); i++) {
                    if (char_v[indexv++]!=pb.charAt(i)) return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new PMatch().patternMatching("a",""));

    }

}
