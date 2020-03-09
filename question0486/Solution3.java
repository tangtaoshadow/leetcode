package question0486;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]:nums数组中[i, j]范围内的数据，先取者能取得的最大值。
 *
 * 状态转移：
 * 当i == j时，dp[i][j] = nums[i]。
 * 当i < j时，dp[i][j] = sum(i, j) - Math.min(dp[i + 1][j], dp[i][j - 1])，其中sum(i, j)为nums数组中[i, j]范围内的和。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为nums数组的长度。
 *
 * 执行用时：2ms，击败55.19%。消耗内存：35MB，击败81.82%。
 */
public class Solution3 {
    //sums[i]表示nums数组中[0, i - 1]范围内元素总和，那么sum[i] - sum[j]代表nums数组中[j, i - 1]范围内的元素和
    private int[] sums;

    private int[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        dp = new int[n][n];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                int sum = sums[j + 1] - sums[i];
                dp[i][j] = sum - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        int first = dp[0][n - 1];
        int second = sums[n] - first;
        if (first >= second) {
            return true;
        }
        return false;
    }
}
