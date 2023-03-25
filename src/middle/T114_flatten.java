package middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T114_flatten {
    List<TreeNode> list = new ArrayList<>();

    /**
     * 空间复杂度为O(n)的做法
     *
     * @param root 根节点
     */
    public void flatten2(TreeNode root) {
        createList(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public void createList(TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root);
        createList(root.left);
        createList(root.right);
    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
                continue;
            }
            TreeNode next = cur.left;
            TreeNode pre = next;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = cur.right;
            cur.right = next;
            cur.left = null;
        }
    }
}
