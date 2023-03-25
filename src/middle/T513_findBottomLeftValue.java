package middle;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T513_findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int value = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isLast = true;
            TreeNode last = queue.peek();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    isLast = false;
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    isLast = false;
                    queue.add(cur.right);
                }
            }
            if (isLast) {
                value = last.val;
            }
        }
        return value;
    }
}
