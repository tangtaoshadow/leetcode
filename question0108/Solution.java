package question0108;

/**
 * 递归。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(logn)。
 *
 * 执行用时：2ms，击败81.12%。消耗内存：38.8MB，击败42.87%。
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, left, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, right);
        return treeNode;
    }
}
