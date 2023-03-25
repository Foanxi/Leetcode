package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T222_countNodes {
    int count = 0;

    /**
     * 计算完全二叉树的节点个数
     *
     * @param root 需要计算节点数的树的根节点
     * @return 返回该树的节点个数
     */
    public int countNodes(TreeNode root) {
        getCount(root);
        return count;
    }

    public void getCount(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.left == null && treeNode.right == null) {
            count++;
            return;
        }

        if (treeNode.left != null) {
            getCount(treeNode.left);
        }

        if (treeNode.right != null) {
            getCount(treeNode.right);
        }

        count++;
    }

    /**
     * 精简写法
     *
     * @param root 需要计算节点数的树的根节点
     * @return 返回该树的节点个数
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
