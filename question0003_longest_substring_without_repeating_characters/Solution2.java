package question0003_longest_substring_without_repeating_characters;

/**
 * 滑动窗口法。
 *
 * 将一个数组当作哈希表。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败97.28%。消耗内存：36.5MB，击败97.26%。
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return 0;
        }
        boolean[] appear = new boolean[256];
        int left = 0, right = -1, result = 0; //滑动窗口范围是[left, right]
        while (right + 1 < n) {
            if (!appear[s.charAt(right + 1)]) {
                right++;
                appear[s.charAt(right)] = true;
            } else {
                appear[s.charAt(left)] = false; //因为滑动窗口中不可能包含重复字符，故去除left处的字符后，滑动窗口将不包含该字符
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}