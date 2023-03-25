package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return getPath(root, targetSum);
    }

    public boolean getPath(TreeNode treeNode, int rest) {
        if (treeNode == null){
            return false;
        }
        if (rest - treeNode.val == 0 && treeNode.left ==null && treeNode.right==null) {
            return true;
        }
        boolean leftPath = getPath(treeNode.left, rest - treeNode.val);
        boolean rightPath = getPath(treeNode.right, rest - treeNode.val);
        return leftPath || rightPath;
    }
}
