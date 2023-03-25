package offer;

import common.TreeNode;

public class T28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root.left, root.right);
    }

    public boolean isValid(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isValid(left.left, right.right) && isValid(left.right, right.left);
        }
        return false;
    }
}
