package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        // 如果当前比较的两个节点都为空则相等
        if (p == null && q == null) {
            return true;
        }

        // 如果当前比较的节点中任意一个为空都不相等，注意此时已经排除两个都相等情况
        if (p == null || q == null) {
            return false;
        }

        // 此处可以拆分为
        // 1.都不为空的情况下比较两个值是否相等，不相等直接返回false，由于短路与的存在，后续不会再递归
        // 2.接着比较当前左节点的左孩子和右节点的右孩子
        // 3.接着比较当前左节点的右孩子和左节点的左孩子
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}