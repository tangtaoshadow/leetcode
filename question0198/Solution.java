package question0198;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]:在[0, i]范围内能偷取到的最大价值。
 *
 * 状态转移：
 * dp[0] = nums[0]
 * dp[1] = Math.max(nums[0], nums[1])
 * 当n >= 2时，考虑两种情况
 * （1）偷取第i号房子，此时最大价值为dp[i - 2] + nums[i]
 * （2）不偷取第i号房子，此时最大价值为dp[i - 1]
 * 因此dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败95.95%。消耗内存：34.2MB，击败88.28%。
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int num1 = nums[0], num2 = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            int tmp = Math.max(num1 + nums[i], num2);
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }
}