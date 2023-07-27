package nowcoder;

import common.TreeNode;

/**
 * @author hujinxu
 */
public class BM36 {
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        boolean b = IsBalanced_Solution(pRoot.left);
        boolean b1 = IsBalanced_Solution(pRoot.right);
        int left = getHeight(pRoot.left);
        int right = getHeight(pRoot.right);
        return Math.abs(left - right) <= 1 & b & b1;
    }

    public int getHeight(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = getHeight(cur.left);
        int right = getHeight(cur.right);
        return Math.max(left, right) + 1;
    }
}
