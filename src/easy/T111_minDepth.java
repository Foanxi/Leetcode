package easy;

import common.Node;
import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T111_minDepth {
    /**
     * 迭代方法，广度搜索
     *
     * @param root 需要得到深度的树的根节点
     * @return 返回树的最小深度
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int result = 0;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left == null && cur.right == null) {
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 递归方法，深度搜索
     *
     * @param root 需要得到深度的树的根节点
     * @return 返回树的深度
     */
    public int minDepth2(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        // 如果左子树为空但右子树不为空，则高度为右子树高度+1
        if (node.left == null && node.right != null) {
            return 1 + rightDepth;
        }
        // 如果右子树为空但左子树不为空，则高度为左子树高度+1
        if (node.right == null && node.left != null) {
            return 1 + leftDepth;
        }
        // 如果都不为空取最小值
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepth3(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right!=null){
            return minDepth3(root.right) + 1;
        }
        if (root.right==null&&root.left!=null){
            return minDepth3(root.left) + 1;
        }
        return 1 + Math.min(minDepth3(root.left),minDepth3(root.right));
    }
}
