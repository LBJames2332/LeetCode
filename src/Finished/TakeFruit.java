package Finished;

public class TakeFruit {
    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了82.27%的用户
     * 内存消耗：49.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        int[] fruits = new int[2];//当前连续情况拿的是哪两种水果
        int[] count = new int[2];
        int findex = 0;//接下来要换掉的是index的水果
        int tindex = 1;//接下来要换掉的是index的水果
        fruits[0] = tree[0];
        count[0]=1;
        while (tree[tindex]==tree[0]) {
            count[0]++;
            tindex++;
        }
        if (tindex==tree.length) return tree.length;
        fruits[1] = tree[tindex++];
        count[1] = 1;
        boolean mark;
        int ans = count[0]+count[1];
        while (tindex<tree.length){
            mark = false;
            do {
                if (tindex==tree.length) return Math.max(ans,count[0]+count[1]);
                if (tree[tindex]==fruits[0]){
                    mark = true;
                    tindex++;
                    count[0]++;
                }
                else if (tree[tindex]==fruits[1]){
                    mark = true;
                    tindex++;
                    count[1]++;
                }
                else mark = false;

            }while (mark);
            ans = Math.max(ans,count[0]+count[1]);
            fruits[findex] = tree[tindex++];
            count[findex] = 1;
            findex^=1;

        }
        return ans;
    }
    public int totalFruit2(int[] tree) {
        int[] fruits = new int[2];//当前连续情况拿的是哪两种水果
        int pointer;//指向某连续相同水果的第一个位置
        int tindex = 1;//接下来要换掉的是index的水果
        fruits[0] = tree[0];
        int count;
        while (tindex<tree.length&&tree[tindex]==tree[0]) {//从第一个开始有几个连续的和第一个相同的则count添加几次 TODO 优化
            tindex++;
        }
        if (tindex==tree.length) return tree.length;
        fruits[1] = tree[tindex];
        pointer = tindex++;
        count = tindex;
        boolean mark;
        int ans = count;
        while (tindex<tree.length){

            do {
                mark = false;

                if (tree[tindex]==fruits[0]){
                    if (tree[pointer]!=tree[tindex]){
                        //更新指针
                        pointer = tindex;
                    }
                    mark = true;
                    tindex++;
                    count++;
                }
                else if (tree[tindex]==fruits[1]){
                    if (tree[pointer]!=tree[tindex]){
                        //更新指针
                        pointer = tindex;
                    }
                    mark = true;
                    tindex++;
                    count++;
                }
                else mark = false;


            }while (tindex<tree.length&&mark);
            //确保循环出来之后pointer指向的是之前讨论的两个元素的当前前缀串的元素
            if (tindex==tree.length) break;
            ans = Math.max(ans,count);

            if (fruits[0]==tree[pointer]) fruits[1] = tree[tindex];
            else fruits[0] = tree[tindex];
            count = (++tindex) - pointer;
            pointer = tindex-1;
        }
        return Math.max(ans,count);
    }
    public static void main(String[] args) {
        System.out.println(new TakeFruit().totalFruit2(new int[]{1,2,1,1,1,3,4,2,2,2,4,2,4,4}));
    }
}
