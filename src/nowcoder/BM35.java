package nowcoder;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hujinxu
 */
public class BM35 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.val == -1) {
                    while (!queue.isEmpty() && queue.peek().val == -1) {
                        queue.poll();
                        size--;
                    }
                    if (!queue.isEmpty() && queue.peek().val != -1) {
                        return false;
                    }
                    if (queue.isEmpty()) {
                        return true;
                    }
                }
                queue.add(poll.left == null ? new TreeNode(-1) : poll.left);
                queue.add(poll.right == null ? new TreeNode(-1) : poll.right);
                size--;
            }
        }
        return true;
    }
}
