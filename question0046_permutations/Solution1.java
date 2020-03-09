package question0046_permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * 回溯法。
 *
 * 时间复杂度是O(n!)，其中n是nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：7ms，击败20.21%。消耗内存：39.7MB，击败36.93%。
 */
public class Solution1 {
    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<>());
        return listList;
    }

    //we put the possible array in list, we are going to find next number
    private void permute(int[] nums, List<Integer> list) {
        int n = nums.length;
        if (list.size() == n) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permute(nums, list);
            list.remove(list.size() - 1);
        }
    }
}