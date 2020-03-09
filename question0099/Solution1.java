package question0099;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 先中序遍历得到中序遍历序列list，再将list进行排序得到正确的中序遍历序列tempList。
 *
 * 比较list和tempList两者，不同的两个节点就是待交换的两个节点。
 *
 * 时间复杂度是O(nlogn)，其中n是树中的节点个数。空间复杂度是O(n)。
 *
 * 执行用时：88ms，击败5.25%。消耗内存：43.8MB，击败72.46%。
 */
public class Solution1 {
    private List<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        List<TreeNode> tempList = new ArrayList<>(list);
        Collections.sort(tempList, Comparator.comparingInt(treeNode -> treeNode.val));
        List<Integer> wrongList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val != tempList.get(i).val) {
                wrongList.add(i);
            }
        }
        swap(list, wrongList.get(0), wrongList.get(1));
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    private void swap(List<TreeNode> list, int i, int j) {
        Integer temp = list.get(i).val;
        list.get(i).val = list.get(j).val;
        list.get(j).val = temp;
    }
}
