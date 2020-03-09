package question0014_longest_common_prefix;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 定义一个函数，求两个字符串s1和s2的最长公共前缀，依次对strs数组中的元素两两调用该函数。
 *
 * 时间复杂度是O(n * m)，其中n为strs数组的大小，m为结果的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败71.31%。消耗内存：36MB，击败87.70%。
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0 || strs[0].length() == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < n; i++) {
            result = longestCommonPrefix(result, strs[i]);
        }
        return result;
    }

    private String longestCommonPrefix(String s1, String s2) {
        int i = 0;
        for (; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0, i);
    }
}