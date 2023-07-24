package nowcoder;

import common.TreeNode;

/**
 * @author hujinxu
 */
public class BM29 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return traversal(root, 0, sum);
    }

    public boolean traversal(TreeNode root, int cur, int target) {
        if (root == null) {
            return false;
        }
        cur = cur + root.val;
        if (root.left == null && root.right == null && cur == target) {
            return true;
        }
        if (root.left != null) {
            if (traversal(root.left, cur, target)) {
                return true;
            }
        }
        if (root.right != null) {
            return traversal(root.right, cur, target);
        }
        return false;
    }
}
