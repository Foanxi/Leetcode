package nowcoder;

import common.TreeNode;

/**
 * @author hujinxu
 */
public class BM31 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return traversal(pRoot, pRoot);
    }

    public boolean traversal(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return traversal(left.left, right.right) & traversal(left.right, right.left);
    }
}
