import java.util.ArrayList;
import java.util.List;

public class CamelMatch {

    char[] char_p;

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char_p = pattern.toCharArray();

        int index = 0;


        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(check(queries[i]));
        }
        return ans;
    }
    private boolean check(String ss) {
        int index_ss = 0;
        int index_p = 0;
        char[] char_s = ss.toCharArray();

        for (char c:char_p){
            if (c<='Z'){
                /**
                 * 遇到一个大写字母，
                 * 则找到下一个大写字母
                 */
                while (index_ss<char_s.length&&char_s[index_ss]>='a') index_ss++;
                if (index_ss==char_s.length) return false;
                if (char_s[index_ss]!=c)return false;//到了下一个大写字母，不相等则返回false

            }
            else {
                /**
                 * 遇到一个小写字母，
                 * 则找这个小写字母，
                 * 前提是不能遇到任何大写字母
                 */
                while (index_ss<char_s.length&&char_s[index_ss]!=c) {
                    //在这样的时候会停止（非return）
                    //1.index超过了
                    //2.找到了
                    if (char_s[index_ss]<='Z') return false;//遇到大写的了。返回false
                    index_ss++;
                }
                if (index_ss==char_s.length) return false;
            }
            //到头了都不能匹配上c，说明找不到了
            index_ss++;
            index_p++;

        }
        if (index_p<char_p.length) return false;
        else {
            while (index_ss<char_s.length){
                if (char_s[index_ss]<='Z') return false;//有别的大写字母，不行
                index_ss++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new CamelMatch().camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FoBaT"));
    }
}
