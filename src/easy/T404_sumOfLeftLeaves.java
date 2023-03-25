package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T404_sumOfLeftLeaves {

    public int count;

    public int sumOfLeftLeaves(TreeNode root) {
        count(root);
        return count;
    }

    public void count(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        count(treeNode.left);
        count(treeNode.right);
        if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
            count += treeNode.left.val;
        }
    }
}
