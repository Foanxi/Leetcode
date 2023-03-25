package easy;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T104_maxDepth {
    /**
     * 递归方法，深度搜索
     *
     * @param root 需要得到深度的树的根节点
     * @return 返回树的深度
     */
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getDepth(treeNode.left);
        int rightDepth = getDepth(treeNode.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代方法，广度搜索
     *
     * @param root 需要得到深度的树的根节点
     * @return 返回树的深度
     */
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int result = 0;
        if (root != null) {
            queue.add(root);
            result++;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result++;
        }
        return result;
    }
}
