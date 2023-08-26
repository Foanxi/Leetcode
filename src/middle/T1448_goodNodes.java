package middle;

import common.TreeNode;

public class T1448_goodNodes {

    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            res++;
        }
        dfs(root.left, Math.max(root.val, max));
        dfs(root.right, Math.max(root.val, max));
    }
}
