package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T687_longestUnivaluePath {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = dfs(cur.left);
        int right = dfs(cur.right);
        int leftCount = 0, rightCount = 0;
        if (cur.left != null && cur.left.val == cur.val) {
            leftCount = left + 1;
        }
        if (cur.right != null && cur.right.val == cur.val) {
            rightCount = right + 1;
        }
        res = Math.max(leftCount + rightCount, res);
        return Math.max(leftCount, rightCount);
    }
}
