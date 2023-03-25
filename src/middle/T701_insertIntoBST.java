package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T701_insertIntoBST {
    /**
     * 自己写法
     *
     * @param root 根节点
     * @param val  值
     * @return 返回整棵二叉树的根节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        traversal(root, val);
        return root;
    }

    public void traversal(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val < val) {
            if (root.right != null) {
                traversal(root.right, val);
            } else {
                root.right = new TreeNode(val);
                return;
            }
        }
        if (root.val > val) {
            if (root.left != null) {
                traversal(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }
    }

    /**
     * 节省内存写法
     *
     * @param root 根节点
     * @param val  值
     * @return 返回整棵二叉树的根节点
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        // 代表已经找到插入位置
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST2(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST2(root.left, val);
        }
        return root;
    }
}
