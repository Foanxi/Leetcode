package offer2;

import common.TreeNode;

public class T47 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null & right == null && root.val == 0) {
            return null;
        } else {
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
