import java.util.Scanner;

public class ModifyString {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        int n = s.nextInt();
        StringBuffer[] a_string = new StringBuffer[n];
        for (int i = 0; i < a_string.length; i++) {
            a_string[i] = new StringBuffer(s.next());
        }
        for (int i = 0; i < a_string.length; i++) {
            ModifyStr(a_string[i]);
        }

        s.close();
    }
    private static void ModifyStr(StringBuffer s){
        //先找到两个不一样的字符
        int count2 = 1;
        char prev2 = s.charAt(0);
        int count1;
        char prev1;
        int position = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==prev2){
                ++count2;
                if (count2==3){
                    s.delete(i,i+1);
                    i--;
                    count2--;
                }
            }
            else {
                //第一次出现第二种字符
                count1 =count2;
                count2 = 1;
                prev1 = prev2;
                prev2 = s.charAt(i);
                for (int j = i+1; j < s.length(); j++) {
                    if (s.charAt(j)!=prev2){
                        prev1 = prev2;
                        prev2 = s.charAt(j);
                        count1=count2;
                        count2=1;
                    }
                    else {
                        if (count1==2){
                            s.delete(j,j+1);
                            j--;
                        }
                        else{
                            if (++count2==3) {
                                s.delete(j,j+1);
                                count2--;
                                j--;
                            }
                        }
                    }
                }
                break;
            }
        }
        System.out.println(s);
    }
}
