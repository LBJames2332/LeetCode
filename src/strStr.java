public class strStr {
    /**给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 执行用时 :4 ms, 在所有 Java 提交中击败了33.95%的用户
     * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了5.43%的用户
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()) return -1;
        boolean success;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            success = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    success = false;
                    break;
                }
            }
            if (success) return i;
        }
        return -1;
    }
}
