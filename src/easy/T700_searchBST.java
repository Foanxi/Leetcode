package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T700_searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result = null;
        if (root == null) {
            return result;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            result = searchBST(root.right, val);
        }
        if (root.val > val) {
            result = searchBST(root.left, val);
        }
        return result;
    }
}
