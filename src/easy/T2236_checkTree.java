package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T2236_checkTree {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
