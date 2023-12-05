package middle;

import common.TreeNode;

public class T1038_bstToGst {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 朝右边走
        root.right = bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        root.left = bstToGst(root.left);
        return root;
    }

}
