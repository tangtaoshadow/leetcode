package question0001_two_sum;

/**
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：31ms，击败42.91%。消耗内存：37.6MB，击败85.93%。
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n;
        if (null == nums || (n = nums.length) < 2) {
            return null;    //如果输入的数组为null或者数组中的元素个数少于2个，直接返回null
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {  //一旦找到了一组符合条件的数据，直接return，因为题目保证了解唯一
                    return new int[] {i, j};
                }
            }
        }
        return null;    //没有找到，直接返回null
    }
}