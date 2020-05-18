package Valuable_for_Practise;

import java.util.*;

public class BiggestSpecialString {
    class Struct{
        int start;
        int end;

        public Struct(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了50.00%的用户
     * @param S
     * @return
     */
    public String makeLargestSpecial(String S) {
        if (S.length()==2) return S;
        char[] char_S = S.toCharArray();
        innerSort(char_S, (byte) 0,(byte)(char_S.length-1),char_S);




        return String.valueOf(char_S);
    }

    /**
     *
     * @param father 其内容刷回的字符数组
     * @param start 其内容原本在father中的起点
     * @param end 其内容原本在father中的终点
     * @param chars father内部的一个待排序的字符数组
     * @return 返回true：有可能有调整
     *             false：必然没有调整(避免不必要的更新数据)
     */

    public boolean innerSort(char[] father,byte start,byte end,char[] chars){
        if (chars.length<3) return false;
        byte count = 0;
        byte fact_head = 0;
        Stack<Struct> s  = new Stack<>();
        List<char[]> list = new ArrayList<>();
        for (byte i = 0; i < chars.length; i++) {

            count = (byte) (count + ((chars[i]=='1')?1:-1));
            if (count == 0){
                /**
                 * 找到1个
                 * 对其内进行排序
                 * 出来再排序
                 * 用comparator的方法（**）
                 */
                if ((i == chars.length - 1)&&fact_head == 0) {
                    //不可以分割的就取1-(len-1)来分割排序
                    if (i - fact_head == 3) return false;
                    char[] newchar = new char[i - fact_head-1];

                    for (byte j = (byte) (fact_head+1); j < i; j++) {
                        newchar[j-fact_head-1] = chars[j];
                    }
                    //TODO check
                    if(innerSort(chars,(byte)(fact_head+1),(byte)(i-1),newchar)){
                        for (byte j = 0; j < chars.length; j++) {
                            father[start++] = chars[j];
                        }
                        return true;
                    }
                    return false;

                }
                char[] newchar = new char[i - fact_head+1];
                for (byte j = fact_head; j <= i; j++) {
                    newchar[j-fact_head] = chars[j];
                }
                //TODO check

                innerSort(chars,fact_head,i,newchar);
                list.add(newchar);
                fact_head = (byte) (i+1);


            }
        }

        list.sort(new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                byte length = (byte) ((o1.length>o2.length)?o2.length:o1.length);
                for (byte i = 0; i < length; i++) {
                    if (o1[i]!=o2[i]){
                        //谁先有一个1，则把它放到前面收益更高
                        return (o1[i]=='1')?-1:1;
                    }
                }
                //若o2短，而o2与o1的前面一段都完全一样，显然，o1不满足最小特殊子串的定义，不存在
                //反之亦然
                //所以走到这儿说明二者完全相同，随意返回正负。
                return -1;
            }
        });
        for (char[] cs:list){
            for (char c:cs){
                father[start++]= c;
            }
        }


        return true;
    }
    public String makeLargestSpecial2(String S) {
        int count = 0;
        int start = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i ++) {
            char cur = S.charAt(i);
            if (cur == '1') count ++;
            else count --;
            if (count == 0) {
                String temp = '1' + makeLargestSpecial(S.substring(start + 1, i)) + '0';
                res.add(temp);
                start = i + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

    public static void main(String[] args) {
        BiggestSpecialString biggestSpecialString = new BiggestSpecialString();
        System.out.println(biggestSpecialString.makeLargestSpecial("11011000"));
    }
}
