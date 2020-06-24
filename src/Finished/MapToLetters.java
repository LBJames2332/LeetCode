package Finished;

public class MapToLetters {
    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了18.14%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了5.09%的用户
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        char[] char_s = s.toCharArray();
        int index = 0;
        int length = char_s.length;
        StringBuilder stringBuilder = new StringBuilder();
        char c = 'a'-1;
        while (index < length){
            if (length-index > 2){
                if (char_s[index+2]!='#'){
                    //System.out.println((char)(Integer.parseInt(char_s[index]+"")+c)+"");
                    stringBuilder.append((char)(Integer.parseInt(char_s[index]+"")+c));
                }

                else {
                    //System.out.println((char)(Integer.parseInt(char_s[index]+""+char_s[index+1])+c)+"");
                    stringBuilder.append((char)(Integer.parseInt(char_s[index++]+""+char_s[index++])+c));
                }

            }
            else {
                stringBuilder.append((char)(Integer.parseInt(char_s[index]+"")+c));
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MapToLetters().freqAlphabets("10#11#12"));
    }
}
