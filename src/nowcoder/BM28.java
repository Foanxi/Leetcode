package nowcoder;

import common.TreeNode;

/**
 * @author hujinxu
 */
public class BM28 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right);
    }
}
