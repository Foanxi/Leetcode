package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T235_lowestCommonAncestor {
    /**
     * 复杂写法
     *
     * @param root 根节点
     * @param p    公共节点的节点之一
     * @param q    公共节点的节点之一
     * @return 返回公共节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
            return root;
        }
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 精简写法
     *
     * @param root 根节点
     * @param p    公共节点的节点之一
     * @param q    公共节点的节点之一
     * @return 返回公共节点
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }

    /**
     * 迭代法
     *
     * @param root 根节点
     * @param p    公共节点的节点之一
     * @param q    公共节点的节点之一
     * @return 返回公共节点
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
