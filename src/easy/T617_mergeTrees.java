package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T617_mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    public TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = merge(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);
        return root;
    }
}
