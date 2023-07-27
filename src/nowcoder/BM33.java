package nowcoder;

import common.TreeNode;

/**
 * @author hujinxu
 * @date 2023/7/25
 * @description
 */
public class BM33 {
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        traversal(pRoot);
        return pRoot;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        traversal(cur.left);
        traversal(cur.right);
    }
}
