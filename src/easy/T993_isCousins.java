package easy;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class T993_isCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode parentX = null;
        TreeNode parentY = null;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    if (cur.left.val == x) {
                        parentX = cur;
                        flag = true;
                    }
                    if (cur.left.val == y) {
                        parentY = cur;
                        flag = true;
                    }
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    if (cur.right.val == x) {
                        parentX = cur;
                        flag = true;
                    }
                    if (cur.right.val == y) {
                        parentY = cur;
                        flag = true;
                    }
                }
            }
            if (flag) {
                if (parentX == null || parentY == null) {
                    return false;
                }
                return parentX != parentY;
            }
        }
        return false;
    }
}
