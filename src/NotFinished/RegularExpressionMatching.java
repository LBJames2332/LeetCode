package NotFinished;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int pos_p;
        for (int i = 0; i < p.length()-s.length()+1; i++) {//改
            //从第i个为起点尝试是否能匹配
            boolean success;
            if (p.charAt(i)==s.charAt(0)||p.charAt(i)=='.'){
                //第一个得匹配到才能开始后面的
                pos_p = i;
                success = true;
                for (int j = 1; j < s.length(); j++) {
                    //比较后面的

                    if (p.charAt(pos_p+j)!=s.charAt(j)){
                        if (p.charAt(pos_p+j)=='.'){}
                        else{
                            if (p.charAt(pos_p+j)=='*'&&((s.charAt(j)==s.charAt(j-1))||p.charAt(pos_p+j-1)=='.')){}
                            else {
                                success = false;
                                break;
                            }
                        }
                    }
                }
                if (success) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*c"));
    }
}
