package offer;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class T55_1 {
    /**
     * BFS
     *
     * @param root 根节点
     * @return 深度
     */
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int result = 0;
        if (root != null) {
            queue.add(root);
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

    /**
     * DFS
     *
     * @param root 根节点
     * @return 深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
