package question0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris后序遍历算法。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.28%。消耗内存35.1MB，击败37.05%。
 */
public class Solution7 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //与Morris前序遍历和Morris中序遍历不同，Morris后序遍历需要设置虚拟根节点
        TreeNode dummyRoot = new TreeNode(-1);
        //令原根节点为虚拟根节点的左孩子
        dummyRoot.left = root;
        TreeNode cur = dummyRoot;
        while (null != cur) {
            if (null == cur.left) {
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    reverseOrder(cur.left, list);   //必须在把pre.right置为null之后再反转
                    cur = cur.right;
                }
            }
        }
        return list;
    }

    private void reverseOrder(TreeNode treeNode, List<Integer> list) {
        int i = list.size();
        while (treeNode != null) {
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }
        int j = list.size() - 1;
        while (i < j) {
            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
            i++;
            j--;
        }
    }
}