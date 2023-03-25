package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T111_isBalanced {
    /**
     * 自己初步代码
     *
     * @param root 需要判断是否为平衡二叉树的树的根节点
     * @return 返回是否为平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean balance = getBalanced(root);
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        return balance & leftBalanced & rightBalanced;
    }

    public boolean getBalanced(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        int leftDepth = getDepth(treeNode.left);
        int rightDepth = getDepth(treeNode.right);
        return Math.abs(leftDepth - rightDepth) <= 1;
    }

    public int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getDepth(treeNode.left);
        int rightDepth = getDepth(treeNode.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 精简代码
     *
     * @param root 需要判断是否为平衡二叉树的树的根节点
     * @return 返回是否为平衡二叉树
     */
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) == -1;
    }

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getHeight(treeNode.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getHeight(treeNode.right);
        if (rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) < 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
