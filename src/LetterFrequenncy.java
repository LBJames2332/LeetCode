import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LetterFrequenncy {
    class type{
        char type;
        int count;

        public type(char type, int count) {
            this.type = type;
            this.count = count;
        }
    }

    /**
     * 执行用时：17 ms, 在所有 Java 提交中击败了60.09%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了11.11%的用户
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        for (char c:s.toCharArray()){
            characterIntegerMap.put(c,characterIntegerMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<type> queue = new PriorityQueue<>(characterIntegerMap.size(), new Comparator<type>() {
            @Override
            public int compare(type o1, type o2) {
                return o2.count - o1.count;
            }
        });
        for (Map.Entry<Character,Integer> entry:characterIntegerMap.entrySet()){
            queue.add(new type(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.peek().count; i++) {
                sb.append(queue.peek().type);
            }
            queue.poll();
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new LetterFrequenncy().frequencySort("tree"));
    }
}
