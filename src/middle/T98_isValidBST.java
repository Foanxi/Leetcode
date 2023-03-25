package middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T98_isValidBST {

    public List<Integer> list = new ArrayList<>();

    /**
     * 使用递归数组检查顺序
     *
     * @param root 根节点
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        if (list.size() == 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void traversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        traversal(treeNode.left);
        list.add(treeNode.val);
        traversal(treeNode.right);
    }

    TreeNode max;

    /**
     * 使用检查是否左子树是否大于当前子树的最大值和检查右子树是否有小于当前子树的最小值
     *
     * @param root 根节点
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        return isValidBST(root.right);
    }
}
