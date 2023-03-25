package offer;

import common.TreeNode;

public class T27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode cur = new TreeNode(root.val);
        cur.right = mirrorTree(root.left);
        cur.left = mirrorTree(root.right);
        return cur;
    }
}
