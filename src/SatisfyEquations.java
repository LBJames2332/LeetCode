import java.util.LinkedList;
import java.util.List;

public class SatisfyEquations {
    byte[] parent;
    int[] size;
    public SatisfyEquations() {
        parent = new byte[26];
        size = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = (byte) i;
            size[i] = 1;
        }
    }
    private void union(byte p,byte s){
        byte p1 = findParent(p);
        byte p2 = findParent(s);
        if (p1!=p2){
            if (size[p1]>size[p2]){
                parent[p2] = p1;
                size[p2] += size [p1];
            }
            else {
                parent[p1] = p2;
                size[p1] += size [p2];
                size[p2] = 0;
            }
        }
    }
    private byte findParent(byte son){
        if (son==parent[son]){
            return son;
        }
        return (parent[son] = findParent(parent[son]));
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了39.06%的用户
     * 内存消耗 :39 MB, 在所有 Java 提交中击败了16.67%的用户
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {

        List<Integer> ll  = new LinkedList<>();
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1)=='='){
                this.union((byte) (equations[i].charAt(0)-'a')
                        ,(byte) (equations[i].charAt(3)-'a'));
            }
            else ll.add(i);
        }
        for (int i:ll){
            if (this.findParent((byte)(equations[i].charAt(0)-'a'))==
                    this.findParent((byte)(equations[i].charAt(3)-'a')))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SatisfyEquations satisfyEquations = new SatisfyEquations();
        System.out.println(satisfyEquations.equationsPossible(new String[]{"a==b",
                "c==d",
                "a==c",
                "a!=c"}));
        System.out.println("checkfind");

    }


}
